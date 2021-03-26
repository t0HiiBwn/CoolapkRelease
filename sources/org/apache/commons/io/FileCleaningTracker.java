package org.apache.commons.io;

import java.io.File;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class FileCleaningTracker {
    final List<String> deleteFailures = Collections.synchronizedList(new ArrayList());
    volatile boolean exitWhenFinished = false;
    ReferenceQueue<Object> q = new ReferenceQueue<>();
    Thread reaper;
    final Collection<Tracker> trackers = Collections.synchronizedSet(new HashSet());

    public void track(File file, Object obj) {
        track(file, obj, (FileDeleteStrategy) null);
    }

    public void track(File file, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        Objects.requireNonNull(file, "The file must not be null");
        addTracker(file.getPath(), obj, fileDeleteStrategy);
    }

    public void track(String str, Object obj) {
        track(str, obj, (FileDeleteStrategy) null);
    }

    public void track(String str, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        Objects.requireNonNull(str, "The path must not be null");
        addTracker(str, obj, fileDeleteStrategy);
    }

    private synchronized void addTracker(String str, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        if (!this.exitWhenFinished) {
            if (this.reaper == null) {
                Reaper reaper2 = new Reaper();
                this.reaper = reaper2;
                reaper2.start();
            }
            this.trackers.add(new Tracker(str, fileDeleteStrategy, obj, this.q));
        } else {
            throw new IllegalStateException("No new trackers can be added once exitWhenFinished() is called");
        }
    }

    public int getTrackCount() {
        return this.trackers.size();
    }

    public List<String> getDeleteFailures() {
        return this.deleteFailures;
    }

    public synchronized void exitWhenFinished() {
        this.exitWhenFinished = true;
        Thread thread = this.reaper;
        if (thread != null) {
            synchronized (thread) {
                this.reaper.interrupt();
            }
        }
    }

    private final class Reaper extends Thread {
        Reaper() {
            super("File Reaper");
            setPriority(10);
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                if (!FileCleaningTracker.this.exitWhenFinished || FileCleaningTracker.this.trackers.size() > 0) {
                    try {
                        Tracker tracker = (Tracker) FileCleaningTracker.this.q.remove();
                        FileCleaningTracker.this.trackers.remove(tracker);
                        if (!tracker.delete()) {
                            FileCleaningTracker.this.deleteFailures.add(tracker.getPath());
                        }
                        tracker.clear();
                    } catch (InterruptedException unused) {
                    }
                } else {
                    return;
                }
            }
        }
    }

    private static final class Tracker extends PhantomReference<Object> {
        private final FileDeleteStrategy deleteStrategy;
        private final String path;

        Tracker(String str, FileDeleteStrategy fileDeleteStrategy, Object obj, ReferenceQueue<? super Object> referenceQueue) {
            super(obj, referenceQueue);
            this.path = str;
            this.deleteStrategy = fileDeleteStrategy == null ? FileDeleteStrategy.NORMAL : fileDeleteStrategy;
        }

        public String getPath() {
            return this.path;
        }

        public boolean delete() {
            return this.deleteStrategy.deleteQuietly(new File(this.path));
        }
    }
}

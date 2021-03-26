package com.coolapk.market.model;

import com.coolapk.market.model.Library;

final class AutoValue_Library extends Library {
    private final String author;
    private final String description;
    private final String title;
    private final String url;

    private AutoValue_Library(String str, String str2, String str3, String str4) {
        this.url = str;
        this.author = str2;
        this.title = str3;
        this.description = str4;
    }

    @Override // com.coolapk.market.model.Library
    public String getUrl() {
        return this.url;
    }

    @Override // com.coolapk.market.model.Library
    public String getAuthor() {
        return this.author;
    }

    @Override // com.coolapk.market.model.Library
    public String getTitle() {
        return this.title;
    }

    @Override // com.coolapk.market.model.Library
    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return "Library{url=" + this.url + ", author=" + this.author + ", title=" + this.title + ", description=" + this.description + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Library)) {
            return false;
        }
        Library library = (Library) obj;
        if (!this.url.equals(library.getUrl()) || !this.author.equals(library.getAuthor()) || !this.title.equals(library.getTitle()) || !this.description.equals(library.getDescription())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((this.url.hashCode() ^ 1000003) * 1000003) ^ this.author.hashCode()) * 1000003) ^ this.title.hashCode()) * 1000003) ^ this.description.hashCode();
    }

    static final class Builder extends Library.Builder {
        private String author;
        private String description;
        private String title;
        private String url;

        Builder() {
        }

        Builder(Library library) {
            this.url = library.getUrl();
            this.author = library.getAuthor();
            this.title = library.getTitle();
            this.description = library.getDescription();
        }

        @Override // com.coolapk.market.model.Library.Builder
        public Library.Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        @Override // com.coolapk.market.model.Library.Builder
        public Library.Builder setAuthor(String str) {
            this.author = str;
            return this;
        }

        @Override // com.coolapk.market.model.Library.Builder
        public Library.Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        @Override // com.coolapk.market.model.Library.Builder
        public Library.Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Override // com.coolapk.market.model.Library.Builder
        public Library build() {
            String str = "";
            if (this.url == null) {
                str = str + " url";
            }
            if (this.author == null) {
                str = str + " author";
            }
            if (this.title == null) {
                str = str + " title";
            }
            if (this.description == null) {
                str = str + " description";
            }
            if (str.isEmpty()) {
                return new AutoValue_Library(this.url, this.author, this.title, this.description);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}

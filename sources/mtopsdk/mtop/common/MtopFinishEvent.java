package mtopsdk.mtop.common;

import mtopsdk.mtop.domain.MtopResponse;

public class MtopFinishEvent extends MtopEvent {
    public MtopResponse mtopResponse;
    public String seqNo;

    public MtopFinishEvent(MtopResponse mtopResponse2) {
        this.mtopResponse = mtopResponse2;
    }

    public MtopResponse getMtopResponse() {
        return this.mtopResponse;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("MtopFinishEvent [seqNo=");
        sb.append(this.seqNo);
        sb.append(", mtopResponse");
        sb.append(this.mtopResponse);
        sb.append("]");
        return sb.toString();
    }
}

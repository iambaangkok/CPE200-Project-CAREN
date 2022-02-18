package com.maikw.CPE200ProjectCAREN;

public class ZoomManager {
    protected Integer attentionPositionX ;
    protected Integer attentionPositionY ;
    protected Integer minZoomFactor ;
    protected Integer maxZoomFactor ;
    protected Integer currentZoomFactor ;


    public ZoomManager(){

    }

    public void ZoomIn(){

    }

    public void ZoomOut(){

    }

    public void resetZoom(){

    }

    public Integer getMinZoomFactor() {
        return minZoomFactor;
    }

    public Integer getMaxZoomFactor() {
        return maxZoomFactor;
    }

    public Integer getAttentionPositionX() {
        return attentionPositionX;
    }

    public void setAttentionPositionX(Integer attentionPositionX) {
        this.attentionPositionX = attentionPositionX;
    }

    public Integer getAttentionPositionY() {
        return attentionPositionY;
    }

    public void setAttentionPositionY(Integer attentionPositionY) {
        this.attentionPositionY = attentionPositionY;
    }

    public Integer getCurrentZoomFactor() {
        return currentZoomFactor;
    }

    public void setCurrentZoomFactor(Integer currentZoomFactor) {
        this.currentZoomFactor = currentZoomFactor;
    }
}

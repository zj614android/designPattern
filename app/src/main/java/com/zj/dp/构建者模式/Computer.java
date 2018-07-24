package com.zj.dp.构建者模式;

public class Computer {

    private String mCpu;
    private String mMainBorad;
    private String mVideoCard;

    public Computer() {
    }

    @Override
    public String toString() {
        return "Computer{" +
                "mCpu='" + mCpu + '\'' +
                ", mMainBorad='" + mMainBorad + '\'' +
                ", mVideoCard='" + mVideoCard + '\'' +
                '}';
    }

    public Computer(String mCpu, String mMainBorad, String mVideoCard) {
        this.mCpu = mCpu;
        this.mMainBorad = mMainBorad;
        this.mVideoCard = mVideoCard;
    }

    public String getCpu() {
        return mCpu;
    }

    public void setCpu(String mCpu) {
        this.mCpu = mCpu;
    }

    public String getMainBorad() {
        return mMainBorad;
    }

    public void setMainBorad(String mMainBorad) {
        this.mMainBorad = mMainBorad;
    }

    public String getVideoCard() {
        return mVideoCard;
    }

    public void setVideoCard(String mVideoCard) {
        this.mVideoCard = mVideoCard;
    }
}

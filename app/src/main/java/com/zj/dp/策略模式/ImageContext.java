package com.zj.dp.策略模式;

/**
 * Context 环境类 具体业务实现
 */
public class ImageContext {

    public static final String GLID = "GLID";
    public static final String FRESCO = "FRESCO";

    private Strategy mImgStrategy;

    /**
     * 具体业务方法
     * @param loadType
     */
    public void loadImage(final String loadType){

        switch (loadType){
            case GLID:
                mImgStrategy = new GlideStrategy();
                break;
            case FRESCO:
                mImgStrategy = new FrescoStrategy();
                break;
        }

        mImgStrategy.imgLoad();
    }



}

package com.zj.dp.策略模式;

/**
 * CLIENT
 */
public class Client {

    public static void main(String[] args) {
        ImageContext mImageContext = new ImageContext();
        mImageContext.loadImage(ImageContext.GLID);
        mImageContext.loadImage(ImageContext.FRESCO);
    }

}

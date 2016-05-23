package cn.edu.bupt.ch2.Buffer;

import java.awt.*;

/**
 * 带缓冲区的画图
 *
 * Created by FirenzesEagle on 2016/5/19 0019.
 * Email:liumingbo2008@gmail.com
 */
public class BufferMovingCircle extends  NoBufferMovingCircle {

    Graphics doubleBuffer = null;					//缓冲区

    public void init() {
        super.init();
        doubleBuffer = screenImage.getGraphics();
    }

    public void paint(Graphics g) {
        doubleBuffer.setColor(Color.white);			//先在内存中画图
        doubleBuffer.fillRect(0, 0, 200, 100);
        drawCircle(doubleBuffer);

        g.drawImage(screenImage, 0, 0, this);		//将buffer一次性显示出来
    }

}

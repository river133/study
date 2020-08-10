package 网络编程.netty.t1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyIo {
    public static void main(String[] args) {
        //用于接收访问
        NioEventLoopGroup boss = new NioEventLoopGroup(5);
        //2代表 用于读写线程
        NioEventLoopGroup worker = new NioEventLoopGroup(2);
        ServerBootstrap boot = new ServerBootstrap();

        try {
            boot.group(boss,worker).channel(NioServerSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY,false)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new MyInbound());
                        }
                    })
                    .bind(9999)
                    .sync() //阻塞当前线程到服务启动起来
                    .channel()
                    .closeFuture()
                    .sync();//阻塞当前线程到服务停止
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
//自定义处理器
class MyInbound extends ChannelInitializer<SocketChannel>{

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

    }
}
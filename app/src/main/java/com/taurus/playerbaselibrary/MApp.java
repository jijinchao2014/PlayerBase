package com.taurus.playerbaselibrary;

import com.kk.taurus.playerbase.config.ConfigLoader;
import com.kk.taurus.playerbase.inter.IPlayer;
import com.kk.taurus.playerbase.setting.DecoderType;
import com.kk.taurus.playerbase.setting.DecoderTypeEntity;
import com.kk.taurus.playerbase.setting.PlayerType;
import com.kk.taurus.playerbase.setting.PlayerTypeEntity;
import com.kk.taurus.uiframe.FrameApplication;
import com.xapp.jjh.logtools.config.XLogConfig;
import com.xapp.jjh.logtools.logger.LogLevel;
import com.xapp.jjh.logtools.tools.XLog;

/**
 * Created by Taurus on 2017/3/28.
 */

public class MApp extends FrameApplication {

    @Override
    public void onCreateInAppMainProcess() {
        super.onCreateInAppMainProcess();

        XLog.init(this,
                new XLogConfig()
                        .setLogLevel(LogLevel.FULL)
                        .setLogDir(getExternalCacheDir())
                        .setFileExtensionName(".txt")
                        .setFileLogAllow(true)
                        .setMessageTable(true));

        /**
         *
         * 如果要实现无缝续播的功能，不能使用VideoView类型的方案，组件模式必须设置为WIDGET_MODE_DECODER
         *
         * **/
        //使用系统MediaPlayer方案
        DecoderType.getInstance().setDefaultDecoderType(0);
        ConfigLoader.setDefaultWidgetMode(this,IPlayer.WIDGET_MODE_DECODER);

//        //使用系统的VideoView方案
//        PlayerType.getInstance().setDefaultPlayerType(0);
//        ConfigLoader.setDefaultWidgetMode(this, IPlayer.WIDGET_MODE_VIDEO_VIEW);
//
//        //使用IJKPlayer的IjkVideoView方案
//        PlayerType.getInstance().addPlayerType(1,new PlayerTypeEntity("IJK播放器","com.kk.taurus.ijkplayer.IJKVideoViewPlayer"));
//        PlayerType.getInstance().setDefaultPlayerType(1);
//        ConfigLoader.setDefaultWidgetMode(this,IPlayer.WIDGET_MODE_VIDEO_VIEW);
//
//        //使用IJKPlayer的IjkMediaPlayer方案
//        DecoderType.getInstance().addDecoderType(1,new DecoderTypeEntity("ijkplayer","com.kk.taurus.ijkplayer.IJkDecoderPlayer"));
//        DecoderType.getInstance().setDefaultDecoderType(1);
//        ConfigLoader.setDefaultWidgetMode(this, IPlayer.WIDGET_MODE_DECODER);
    }

}

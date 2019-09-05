package com.bob.code.layout.inflater;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 *  LayoutInflater 就是将XML布局文件实例化相应的View对象
 */
public class LayoutInflater {

    protected final Context mContext;

    /**
     * 工厂接口
     */
    public interface Factory{
        View onCreateView(String name, Context context, AttributeSet attrs);
    }

    public interface Factory2 extends Factory{
        View onCreateView(View parent, String name, Context context, AttributeSet attrs);
    }



    /**
     * 构造函数
     */
    public LayoutInflater(Context mContext) {
        this.mContext = mContext;
    }

    protected LayoutInflater(LayoutInflater original, Context newContext) {
        mContext = newContext;
    }


    /**
     * 获取该类的静态方法
     */
    public static android.view.LayoutInflater from(Context context) {
        //上下文获取 系统服务的流程
        android.view.LayoutInflater layoutInflater =
                (android.view.LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        return layoutInflater;
    }



    public View inflate(int resource, ViewGroup root){
        return inflate(resource, root, root!=null);
    }

    private View inflate(int resource, ViewGroup root, boolean attachToRoot) {
        final Resources res = getContext().getResources();

        final XmlResourceParser parser = res.getLayout(resource);

//        inflate(parser, root, attachToRoot)
        return null;
    }

    public View inflate(XmlResourceParser parser, ViewGroup root, boolean attachToRoot) {
        int type;
        while (true) {
            try {
                if (!((type = parser.next()) != XmlPullParser.START_TAG && type != XmlPullParser.END_DOCUMENT)){

                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }
    }



    public Context getContext() {
        return mContext;
    }

}

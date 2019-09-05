package com.bob.code.layout.inflater;

import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.RequiresApi;
import org.xmlpull.v1.XmlPullParser;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public interface XmlResourceParser extends XmlPullParser, AttributeSet, AutoCloseable {

    String getAttributeNamespace(int var1);

    @Override
    void close() throws Exception;

    /**
     * XmlPullParser
     *
     * xml文件
     * <?xml version="1.0" encoding="UTF-8"?>    
     * <beauties>    
     *     <daxiongmei>    
     *         <name>杨幂</name>    
     *         <age>28</age>    
     *     </daxiongmei>    
     *     <daxiongmei>    
     *         <name>范冰冰</name>    
     *         <age>23</age>    
     *     </daxiongmei>    
     * </beauties> 
     *
     */
}

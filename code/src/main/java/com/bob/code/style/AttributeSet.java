package com.bob.code.style;

/**
 * values -- attrs 文件中
 *     <declare-styleable name="MyView">
 *         <attr name="textColor" format="color"/>
 *         <attr name="textSize" format="dimension"/>
 *     </declare-styleable>
 *
 *
 *  public MyView(Context context, AttributeSet attrs) {
 *         super(context, attrs);
 *
 *         TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MyView);
 *         int textColor = array.getColor(R.styleable.MyView_textColor, 0XFF00FF00);
 *         int textColor = array.getColor(R.styleable.MyView_textColor, 0XFF00FF00);
 *         setTextColor(textColor);
 *         setTextSize(textSize);
 *
 *         array.recycle();
 *  }
 */
public interface AttributeSet {

    //返回集合Set 中的属性数量
    int getAttributeCount();

    default String getAttributeNamespace(int index) {
        throw new RuntimeException("Stub!");
    }

    //index 对应属性的索引值 0到count-1
    //返回对应的属性名称
    String getAttributeName(int var1);

    //以字符串的形式 返回属性对应的值
    String getAttributeValue(int var1);

    //namespace -- 命名空间 从中获取值的属性的命名空间
    //name -- 属性名
    //返回属性对应的值 以字符串的形式返回
    String getAttributeValue(String namespace, String name);

    //返回属性集当前位置的描述
    //例如: 如果属性集是从XML文档加载的，
    //      位置描述可以指示当前行号
    String getPositionDescription();

    //
    int getAttributeNameResource(int var1);

    int getAttributeListValue(String var1, String var2, String[] var3, int var4);

    boolean getAttributeBooleanValue(String var1, String var2, boolean var3);

    int getAttributeResourceValue(String var1, String var2, int var3);

    int getAttributeIntValue(String var1, String var2, int var3);

    int getAttributeUnsignedIntValue(String var1, String var2, int var3);

    float getAttributeFloatValue(String var1, String var2, float var3);

    int getAttributeListValue(int var1, String[] var2, int var3);

    boolean getAttributeBooleanValue(int var1, boolean var2);

    int getAttributeResourceValue(int var1, int var2);

    int getAttributeIntValue(int var1, int var2);

    int getAttributeUnsignedIntValue(int var1, int var2);

    float getAttributeFloatValue(int var1, float var2);

    String getIdAttribute();

    String getClassAttribute();

    int getIdAttributeResourceValue(int var1);

    int getStyleAttribute();

}
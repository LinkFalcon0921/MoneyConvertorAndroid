package com.flintcore.tarea_2_movil.utils;

public class StringMapper {

    private static StringMapper mapper;

    private StringMapper(){}

    public static StringMapper getInstance(){
        if (mapper == null) {
            mapper = new StringMapper();
        }

        return mapper;
    }

    public String getSubSequenceOf(CharSequence text, String start, String end){
        String sText = text.toString();
        int startIndex = sText.indexOf(start);
        int endIndex = sText.lastIndexOf(end);

        return mapper.getSubSequenceOf(text, startIndex, endIndex);
    }

    public String getSubSequenceOf(CharSequence text, String endIncluded){
        String sText = text.toString();
        int endIndex = sText.lastIndexOf(endIncluded) + 1;

        return mapper.getSubSequenceOf(text, 0, endIndex);
    }

    public String getSubSequenceOf(CharSequence text, int start, int endIncluded){
        return text.subSequence(start, endIncluded).toString();
    }


}

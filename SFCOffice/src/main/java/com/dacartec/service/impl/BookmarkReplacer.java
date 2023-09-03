package com.dacartec.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.TempFileCreationStrategy;
import org.apache.poi.xdgf.usermodel.section.geometry.RelMoveTo;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

/**
 * 
 * @author binita.bharati@gmail.com
 * 
 * This code will replace bookmark with plain text. A bookmark is seen as "Text Form Field" in a .docx file.
 *
 */


public class BookmarkReplacer {

    public static void main(String[] args) throws Exception {
        replaceBookmark();

    }

    private static String replaceBookmarkedPara(String input, String bookmarkTxt) {
        char[] tmp = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        int bookmarkedCharCount = 0;
        for (int i = 0 ; i < tmp.length ; i++) {
            int asciiCode = tmp[i];
            if (asciiCode == 8194) {
                bookmarkedCharCount ++;
                if (bookmarkedCharCount == 5) {
                    sb.append(bookmarkTxt);
                }
            }
            else {
                sb.append(tmp[i]);
            }
        }
        return sb.toString();
    }

    private static void removeAllRuns(XWPFParagraph paragraph) {
        int size = paragraph.getRuns().size();
        for (int i = 0; i < size; i++) {
            paragraph.removeRun(0);
        }
    }

    private static void insertReplacementRuns(XWPFParagraph paragraph, String replacedText) {
        String[] replacementTextSplitOnCarriageReturn = StringUtils.split(replacedText, "\n");

        for (int j = 0; j < replacementTextSplitOnCarriageReturn.length; j++) {
            String part = replacementTextSplitOnCarriageReturn[j];

            XWPFRun newRun = paragraph.insertNewRun(j);
            newRun.setText(part);

            if (j+1 < replacementTextSplitOnCarriageReturn.length) {
                newRun.addCarriageReturn();
            }
        }       
    }

    public static void replaceBookmark () throws Exception 
    {
    InputStream fis = new FileInputStream("C:\\Users\\alvar\\Downloads\\13_89.docx");
    XWPFDocument document = new XWPFDocument(fis);
    List<XWPFParagraph> paragraphs = document.getParagraphs();
    for (XWPFParagraph paragraph : paragraphs)
    {
        //Here you have your paragraph; 
        CTP ctp = paragraph.getCTP(); 
        // Get all bookmarks and loop through them 
        List<CTBookmark> bookmarks = ctp.getBookmarkStartList(); 
        for(CTBookmark bookmark : bookmarks) 
        { 
             if(bookmark.getName().equals("data_incipit") || bookmark.getName().equals("incipit_Codcli")
                     || bookmark.getName().equals("Incipit_titolo"))
             {

                 String paraText = paragraph.getText();
                 System.out.println("paraText = "+paraText +" for bookmark name "+bookmark.getName());
                 String replacementText = replaceBookmarkedPara(paraText, "haha");
                 removeAllRuns(paragraph);
                 insertReplacementRuns(paragraph, replacementText);

             }
        }   
    }
    OutputStream out = new FileOutputStream("C:\\output.docx");
    document.write(out);
    document.close();
    out.close();  
}
}
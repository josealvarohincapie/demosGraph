package com.dacartec.service.impl;

import com.spire.doc.Document;
import com.spire.doc.documents.BookmarksNavigator;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.documents.TextBodyPart;
import com.spire.doc.fields.TextRange;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Bookmark {

    public static void main(String[] args) throws FileNotFoundException {

        //create a Document object
        Document doc = new Document();

        //load a sample Word file
        doc.loadFromFile("C:\\Users\\alvar\\Downloads\\13_89.docx");

        //get the specific bookmark
        BookmarksNavigator navigator = new BookmarksNavigator(doc);
        navigator.moveToBookmark("nombreActividad");

        //get the bookmark content
        TextBodyPart textBodyPart = navigator.getBookmarkContent();

        //declare a String variable
        String text = "";

        //loop through body items
        for (Object item : textBodyPart.getBodyItems()) {

            //determine if an item is a paragraph
            if (item instanceof Paragraph) {
                Paragraph paragraph = (Paragraph) item;

                //loop through the child objects of the paragraph
                for (Object childObj : paragraph.getChildObjects()) {

                    //determine if a child object is a text range
                    if (childObj instanceof TextRange) {

                        //get text from the text range
                        TextRange textRange = (TextRange) childObj;
                        text = text + textRange.getText();
                    }
                }
            }
        }

        //write the bookmark text to a .txt file
        PrintWriter printWriter = new PrintWriter("C:\\Users\\alvar\\Downloads\\BookmarkText.txt");
        printWriter.println(text);
        printWriter.close();
    }
}
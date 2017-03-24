package com.librarymanager.ui;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

/**
 * Created by ramiawar on 3/24/17.
 */
public class icons {

    public static FontAwesomeIconView ADD_USER = new FontAwesomeIconView(FontAwesomeIcon.USER_PLUS);
    public static FontAwesomeIconView LIST_USERS = new FontAwesomeIconView(FontAwesomeIcon.USERS);
    public static FontAwesomeIconView ADD_BOOK = new FontAwesomeIconView(FontAwesomeIcon.LEANPUB);
    public static FontAwesomeIconView LIST_BOOKS = new FontAwesomeIconView(FontAwesomeIcon.LIST);
    public static FontAwesomeIconView SETTINGS = new FontAwesomeIconView(FontAwesomeIcon.COG);

    public static void setSize(String size){
        ADD_USER.setSize(size);
        LIST_USERS.setSize(size);
        ADD_BOOK.setSize(size);
        LIST_BOOKS.setSize(size);
        SETTINGS.setSize(size);
    }
}

/***********************************************************************
 * Database.java is part of Titanium4j 2.0 Beta
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * For licensing questions, please contact us at licensing@emitrom.com
 * 
 * ------ Titanium4j is released under a commercial license only ------
 * 
 * http://www.emitrom.com/license?q=commercialLicense
 ***********************************************************************/
package com.emitrom.gwt4.ti.mobile.client.database;

import com.emitrom.gwt4.ti.mobile.client.core.TiFactory;
import com.emitrom.gwt4.ti.mobile.client.core.TiModule;

/**
 * * The top level database module. the database module is used for creating and
 * accessing the in-application database.
 * 
 * @author Ekambi
 * 
 */
public class Database extends TiModule {

    public static final int FIELD_TYPE_DOUBLE = FIELD_TYPE_DOUBLE();
    public static final int FIELD_TYPE_FLOAT = FIELD_TYPE_FLOAT();
    public static final int FIELD_TYPE_INT = FIELD_TYPE_INT();
    public static final int FIELD_TYPE_STRING = FIELD_TYPE_STRING();
    private static Database instance = null;

    public static Database get() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    private Database() {
        createPeer();
    }

    public native DB createDB() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		var obj = jso.createDB();
		var toReturn = @com.emitrom.gwt4.ti.mobile.client.database.DB::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    public native ResultSet createResultSet() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		var obj = jso.createResultSet();
		var toReturn = @com.emitrom.gwt4.ti.mobile.client.database.ResultSet::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * Install a database from the application resources folder (at build time)
     * and return a reference to the opened database. it is safe to call this
     * method multiple times since this method will only install once if it
     * doesn't already exist on the device.
     * 
     * @param path
     *            the path (relative to the main application Resources folder at
     *            build time) to the db to install. this file must be in the
     *            SQLite 3 file format.
     * @param name
     *            the name of the database
     */
    public static native DB install(String path, String name) /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		var obj = jso.install(path, name);
		var toReturn = @com.emitrom.gwt4.ti.mobile.client.database.DB::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * Open a database. if it doesn't yet exist, create it.
     * 
     * @param name
     *            the name of the database
     */
    public native DB open(String name) /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		var obj = jso.open(name);
		var toReturn = @com.emitrom.gwt4.ti.mobile.client.database.DB::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    private static native final int FIELD_TYPE_DOUBLE() /*-{
		return Titanium.Database.FIELD_TYPE_DOUBLE;
    }-*/;

    private static native final int FIELD_TYPE_FLOAT() /*-{
		return Titanium.Database.FIELD_TYPE_FLOAT;
    }-*/;

    private static native final int FIELD_TYPE_INT() /*-{
		return Titanium.Database.FIELD_TYPE_INT;
    }-*/;

    private static native final int FIELD_TYPE_STRING() /*-{
		return Titanium.Database.FIELD_TYPE_STRING;
    }-*/;

    @Override
    public void createPeer() {
        jsObj = TiFactory.createNativeDatabaseModule();
    }

}

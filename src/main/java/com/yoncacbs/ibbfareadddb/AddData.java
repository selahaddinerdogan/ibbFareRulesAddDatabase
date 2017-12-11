/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yoncacbs.ibbfareadddb;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author lenova
 */
public class AddData {

    public void sehir_hatlari() throws FileNotFoundException, UnsupportedEncodingException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("files\\sehir_hatlari.txt"), "UTF-8"));
        String line;
        DBTool db = new DBTool();
        db.connect();
        while ((line = br.readLine()) != null) {
            String[] arr = line.split(";");
            if(!arr[0].equals("route_id")){
            String sql = "INSERT INTO public.fare_attributes(route_id, agency_id, price, transfer, transfer_duration, currency_type)\n"
                    + "	VALUES (" + arr[0] + ", " + arr[1] + ", " + arr[5] + ", 0, 0, 'TRY');";
            //System.out.println(sql);
            db.execute(sql);
            }
            
        }
        db.closeConn();
    }

    public void taksi_dolmus() throws FileNotFoundException, UnsupportedEncodingException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("files\\taksi_dolmus.txt"), "UTF-8"));
        String line;
        DBTool db = new DBTool();
        db.connect();
        while ((line = br.readLine()) != null) {
            String[] arr = line.split(";");
            if(!arr[0].equals("route_id")){
            String sql = "INSERT INTO public.fare_attributes(route_id, agency_id, price, transfer, transfer_duration, currency_type)\n"
                    + "	VALUES (" + arr[0] + ", " + arr[1] + ", " + arr[6] + ", 0, 0, 'TRY');";
            //System.out.println(sql);
            db.execute(sql);
            }
        }
        db.closeConn();
    }

    public void ido() throws FileNotFoundException, UnsupportedEncodingException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("files\\ido.txt"), "UTF-8"));
        String line;
        DBTool db = new DBTool();
        db.connect();
        while ((line = br.readLine()) != null) {
            String[] arr = line.split(",");
            if(!arr[0].equals("route_id")){
            String sql = "INSERT INTO public.fare_attributes(route_id, agency_id, price, transfer, transfer_duration, currency_type)\n"
                    + "	VALUES (" + arr[0] + ", " + arr[1] + ", " + arr[5] + ", 0, 0, 'TRY');";
            //System.out.println(sql);
            db.execute(sql);
             }
            /*
            INSERT INTO public.fare_attributes(route_id, agency_id, price, transfer, transfer_duration, currency_type)
SELECT public.routes.id 12, 5.2, 0, 0, 'TRY' FROM public.routes WHERE short_name='76T';



	--VALUES (SELECT id FROM public.routes where short_name='76T', 12, 5.2, 0, 0, 'TRY');-- 
           */
        }
        db.closeConn();
    }
    
    public void iett() throws FileNotFoundException, UnsupportedEncodingException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("files\\iett.txt"), "UTF-8"));
        String line;
        DBTool db = new DBTool();
        db.connect();
        while ((line = br.readLine()) != null) {
            String[] arr = line.split(";");
            if(!arr[0].equals("route_id")){
            String sql = "INSERT INTO public.fare_attributes(route_id, agency_id, price, transfer, transfer_duration, currency_type)\n"
                    + "	VALUES ((SELECT id FROM public.routes where public.routes.short_name='" + arr[0] + "'), 12, " + arr[2] + ", 0, 0, 'TRY');";
           // System.out.println(sql);
           db.execute(sql);
            }

        }
        db.closeConn();
    }
    
    public void transfer_duration() throws FileNotFoundException, UnsupportedEncodingException, IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("files\\transfer_duration.txt"), "UTF-8"));
        String line;
        DBTool db = new DBTool();
        db.connect();
        while ((line = br.readLine()) != null) {
            String[] arr = line.split(",");
            if(!arr[0].equals("agency_id")){
            String sql = "INSERT INTO public.transfer_duration(agency_id, transfer_duration)\n"
                    + "	VALUES (" + arr[0] + "," + arr[1] + ");";
           // System.out.println(sql);
            db.execute(sql);
            }

        }
        db.closeConn();
    }
    
    public void fare_transfer() throws FileNotFoundException, UnsupportedEncodingException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("files\\fare_transfer.txt"), "UTF-8"));
        String line;
        DBTool db = new DBTool();
        db.connect();
        while ((line = br.readLine()) != null) {
            String[] arr = line.split(",");
            if(!arr[0].equals("transfer_id")){
            String sql = "INSERT INTO public.fare_transfer(transfer_id, agency_id, price, description)\n"
                    + "	VALUES (" + arr[0] + ", " + arr[1] + ", " + arr[2] + ", '" + arr[3] + "');";
           // System.out.println(sql);
            db.execute(sql);
             }
        }
        db.closeConn();
    }

    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        
        AddData add = new AddData();
      // add.sehir_hatlari();
       // add.ido();
       // add.taksi_dolmus();
     //   add.iett();
      // add.transfer_duration();
       //add.fare_transfer();
    }
}

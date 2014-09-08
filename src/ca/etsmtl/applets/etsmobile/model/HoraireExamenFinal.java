package ca.etsmtl.applets.etsmobile.model;

//----------------------------------------------------
//
//Generated by www.easywsdl.com
//Version: 4.0.1.0
//
//Created by Quasar Development at 03-09-2014
//
//---------------------------------------------------


import java.util.Hashtable;

import org.ksoap2.serialization.*;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import ca.etsmtl.applets.etsmobile.http.soap.ExtendedSoapSerializationEnvelope;

@DatabaseTable(tableName = "horaire_examen_final")
public class HoraireExamenFinal extends AttributeContainer implements KvmSerializable
{
  
  @DatabaseField
  public String sigle;
  
  @DatabaseField
  public String groupe;
  
  @DatabaseField
  public String dateExamen;
  
  @DatabaseField
  public String heureDebut;
  
  @DatabaseField
  public String heureFin;
  
  @DatabaseField
  public String local;
  
  @DatabaseField(id = true)
  public String id;

  public HoraireExamenFinal ()
  {
  }

  public HoraireExamenFinal (AttributeContainer inObj,ExtendedSoapSerializationEnvelope envelope)
  {
	  if (inObj == null)
          return;

      SoapObject soapObject=(SoapObject)inObj;  
      if (soapObject.hasProperty("sigle"))
      {	
    	  Object obj = soapObject.getProperty("sigle");
          if (obj != null && obj.getClass().equals(SoapPrimitive.class))
          {
              SoapPrimitive j =(SoapPrimitive) obj;
              if(j.toString()!=null)
              {
                  this.sigle = j.toString();
              }
	        }
	        else if (obj!= null && obj instanceof String){
              this.sigle = (String)obj;
          }    
      }
      if (soapObject.hasProperty("groupe"))
      {	
	        java.lang.Object obj = soapObject.getProperty("groupe");
          if (obj != null && obj.getClass().equals(SoapPrimitive.class))
          {
              SoapPrimitive j =(SoapPrimitive) obj;
              if(j.toString()!=null)
              {
                  this.groupe = j.toString();
              }
	        }
	        else if (obj!= null && obj instanceof String){
              this.groupe = (String)obj;
          }    
      }
      if (soapObject.hasProperty("dateExamen"))
      {	
	        java.lang.Object obj = soapObject.getProperty("dateExamen");
          if (obj != null && obj.getClass().equals(SoapPrimitive.class))
          {
              SoapPrimitive j =(SoapPrimitive) obj;
              if(j.toString()!=null)
              {
                  this.dateExamen = j.toString();
              }
	        }
	        else if (obj!= null && obj instanceof String){
              this.dateExamen = (String)obj;
          }    
      }
      if (soapObject.hasProperty("heureDebut"))
      {	
	        java.lang.Object obj = soapObject.getProperty("heureDebut");
          if (obj != null && obj.getClass().equals(SoapPrimitive.class))
          {
              SoapPrimitive j =(SoapPrimitive) obj;
              if(j.toString()!=null)
              {
                  this.heureDebut = j.toString();
              }
	        }
	        else if (obj!= null && obj instanceof String){
              this.heureDebut = (String)obj;
          }    
      }
      if (soapObject.hasProperty("heureFin"))
      {	
	        java.lang.Object obj = soapObject.getProperty("heureFin");
          if (obj != null && obj.getClass().equals(SoapPrimitive.class))
          {
              SoapPrimitive j =(SoapPrimitive) obj;
              if(j.toString()!=null)
              {
                  this.heureFin = j.toString();
              }
	        }
	        else if (obj!= null && obj instanceof String){
              this.heureFin = (String)obj;
          }    
      }
      if (soapObject.hasProperty("local"))
      {	
	        java.lang.Object obj = soapObject.getProperty("local");
          if (obj != null && obj.getClass().equals(SoapPrimitive.class))
          {
              SoapPrimitive j =(SoapPrimitive) obj;
              if(j.toString()!=null)
              {
                  this.local = j.toString();
              }
	        }
	        else if (obj!= null && obj instanceof String){
              this.local = (String)obj;
          }    
      }


  }

  @Override
  public java.lang.Object getProperty(int propertyIndex) {
      //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
      //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
      if(propertyIndex==0)
      {
          return sigle;
      }
      if(propertyIndex==1)
      {
          return groupe;
      }
      if(propertyIndex==2)
      {
          return dateExamen;
      }
      if(propertyIndex==3)
      {
          return heureDebut;
      }
      if(propertyIndex==4)
      {
          return heureFin;
      }
      if(propertyIndex==5)
      {
          return local;
      }
      return null;
  }


  @Override
  public int getPropertyCount() {
      return 6;
  }

  @Override
  public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info)
  {
      if(propertyIndex==0)
      {
          info.type = PropertyInfo.STRING_CLASS;
          info.name = "sigle";
          info.namespace= "http://etsmtl.ca/";
      }
      if(propertyIndex==1)
      {
          info.type = PropertyInfo.STRING_CLASS;
          info.name = "groupe";
          info.namespace= "http://etsmtl.ca/";
      }
      if(propertyIndex==2)
      {
          info.type = PropertyInfo.STRING_CLASS;
          info.name = "dateExamen";
          info.namespace= "http://etsmtl.ca/";
      }
      if(propertyIndex==3)
      {
          info.type = PropertyInfo.STRING_CLASS;
          info.name = "heureDebut";
          info.namespace= "http://etsmtl.ca/";
      }
      if(propertyIndex==4)
      {
          info.type = PropertyInfo.STRING_CLASS;
          info.name = "heureFin";
          info.namespace= "http://etsmtl.ca/";
      }
      if(propertyIndex==5)
      {
          info.type = PropertyInfo.STRING_CLASS;
          info.name = "local";
          info.namespace= "http://etsmtl.ca/";
      }
  }
  
  @Override
  public void setProperty(int arg0, java.lang.Object arg1)
  {
  }

}
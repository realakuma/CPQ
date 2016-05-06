/**
 * NotificationPreferenceType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bigmachines.soap;

public class NotificationPreferenceType  implements java.io.Serializable {
    private java.lang.Boolean is_notify_email;

    private java.lang.Boolean is_notify_fax;

    public NotificationPreferenceType() {
    }

    public NotificationPreferenceType(
           java.lang.Boolean is_notify_email,
           java.lang.Boolean is_notify_fax) {
           this.is_notify_email = is_notify_email;
           this.is_notify_fax = is_notify_fax;
    }


    /**
     * Gets the is_notify_email value for this NotificationPreferenceType.
     * 
     * @return is_notify_email
     */
    public java.lang.Boolean getIs_notify_email() {
        return is_notify_email;
    }


    /**
     * Sets the is_notify_email value for this NotificationPreferenceType.
     * 
     * @param is_notify_email
     */
    public void setIs_notify_email(java.lang.Boolean is_notify_email) {
        this.is_notify_email = is_notify_email;
    }


    /**
     * Gets the is_notify_fax value for this NotificationPreferenceType.
     * 
     * @return is_notify_fax
     */
    public java.lang.Boolean getIs_notify_fax() {
        return is_notify_fax;
    }


    /**
     * Sets the is_notify_fax value for this NotificationPreferenceType.
     * 
     * @param is_notify_fax
     */
    public void setIs_notify_fax(java.lang.Boolean is_notify_fax) {
        this.is_notify_fax = is_notify_fax;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NotificationPreferenceType)) return false;
        NotificationPreferenceType other = (NotificationPreferenceType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.is_notify_email==null && other.getIs_notify_email()==null) || 
             (this.is_notify_email!=null &&
              this.is_notify_email.equals(other.getIs_notify_email()))) &&
            ((this.is_notify_fax==null && other.getIs_notify_fax()==null) || 
             (this.is_notify_fax!=null &&
              this.is_notify_fax.equals(other.getIs_notify_fax())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getIs_notify_email() != null) {
            _hashCode += getIs_notify_email().hashCode();
        }
        if (getIs_notify_fax() != null) {
            _hashCode += getIs_notify_fax().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NotificationPreferenceType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "NotificationPreferenceType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("is_notify_email");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "is_notify_email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("is_notify_fax");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "is_notify_fax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

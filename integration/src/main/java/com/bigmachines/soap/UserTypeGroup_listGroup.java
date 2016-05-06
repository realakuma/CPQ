/**
 * UserTypeGroup_listGroup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bigmachines.soap;

public class UserTypeGroup_listGroup  implements java.io.Serializable {
    private java.lang.String variable_name;

    public UserTypeGroup_listGroup() {
    }

    public UserTypeGroup_listGroup(
           java.lang.String variable_name) {
           this.variable_name = variable_name;
    }


    /**
     * Gets the variable_name value for this UserTypeGroup_listGroup.
     * 
     * @return variable_name
     */
    public java.lang.String getVariable_name() {
        return variable_name;
    }


    /**
     * Sets the variable_name value for this UserTypeGroup_listGroup.
     * 
     * @param variable_name
     */
    public void setVariable_name(java.lang.String variable_name) {
        this.variable_name = variable_name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserTypeGroup_listGroup)) return false;
        UserTypeGroup_listGroup other = (UserTypeGroup_listGroup) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.variable_name==null && other.getVariable_name()==null) || 
             (this.variable_name!=null &&
              this.variable_name.equals(other.getVariable_name())));
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
        if (getVariable_name() != null) {
            _hashCode += getVariable_name().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserTypeGroup_listGroup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">>UserType>group_list>group"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("variable_name");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "variable_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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

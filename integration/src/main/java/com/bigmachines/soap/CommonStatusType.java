/**
 * CommonStatusType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bigmachines.soap;

public class CommonStatusType  implements java.io.Serializable {
    private java.lang.String success;

    private java.lang.String message;

    private java.lang.Integer records_read;

    private java.lang.Integer records_failed;

    private java.lang.Integer records_deleted;

    private java.lang.Integer records_returned;

    private java.lang.Integer records_inserted;

    private java.lang.Integer records_updated;

    private java.lang.String detail;

    private java.lang.String warning;

    public CommonStatusType() {
    }

    public CommonStatusType(
           java.lang.String success,
           java.lang.String message,
           java.lang.Integer records_read,
           java.lang.Integer records_failed,
           java.lang.Integer records_deleted,
           java.lang.Integer records_returned,
           java.lang.Integer records_inserted,
           java.lang.Integer records_updated,
           java.lang.String detail,
           java.lang.String warning) {
           this.success = success;
           this.message = message;
           this.records_read = records_read;
           this.records_failed = records_failed;
           this.records_deleted = records_deleted;
           this.records_returned = records_returned;
           this.records_inserted = records_inserted;
           this.records_updated = records_updated;
           this.detail = detail;
           this.warning = warning;
    }


    /**
     * Gets the success value for this CommonStatusType.
     * 
     * @return success
     */
    public java.lang.String getSuccess() {
        return success;
    }


    /**
     * Sets the success value for this CommonStatusType.
     * 
     * @param success
     */
    public void setSuccess(java.lang.String success) {
        this.success = success;
    }


    /**
     * Gets the message value for this CommonStatusType.
     * 
     * @return message
     */
    public java.lang.String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this CommonStatusType.
     * 
     * @param message
     */
    public void setMessage(java.lang.String message) {
        this.message = message;
    }


    /**
     * Gets the records_read value for this CommonStatusType.
     * 
     * @return records_read
     */
    public java.lang.Integer getRecords_read() {
        return records_read;
    }


    /**
     * Sets the records_read value for this CommonStatusType.
     * 
     * @param records_read
     */
    public void setRecords_read(java.lang.Integer records_read) {
        this.records_read = records_read;
    }


    /**
     * Gets the records_failed value for this CommonStatusType.
     * 
     * @return records_failed
     */
    public java.lang.Integer getRecords_failed() {
        return records_failed;
    }


    /**
     * Sets the records_failed value for this CommonStatusType.
     * 
     * @param records_failed
     */
    public void setRecords_failed(java.lang.Integer records_failed) {
        this.records_failed = records_failed;
    }


    /**
     * Gets the records_deleted value for this CommonStatusType.
     * 
     * @return records_deleted
     */
    public java.lang.Integer getRecords_deleted() {
        return records_deleted;
    }


    /**
     * Sets the records_deleted value for this CommonStatusType.
     * 
     * @param records_deleted
     */
    public void setRecords_deleted(java.lang.Integer records_deleted) {
        this.records_deleted = records_deleted;
    }


    /**
     * Gets the records_returned value for this CommonStatusType.
     * 
     * @return records_returned
     */
    public java.lang.Integer getRecords_returned() {
        return records_returned;
    }


    /**
     * Sets the records_returned value for this CommonStatusType.
     * 
     * @param records_returned
     */
    public void setRecords_returned(java.lang.Integer records_returned) {
        this.records_returned = records_returned;
    }


    /**
     * Gets the records_inserted value for this CommonStatusType.
     * 
     * @return records_inserted
     */
    public java.lang.Integer getRecords_inserted() {
        return records_inserted;
    }


    /**
     * Sets the records_inserted value for this CommonStatusType.
     * 
     * @param records_inserted
     */
    public void setRecords_inserted(java.lang.Integer records_inserted) {
        this.records_inserted = records_inserted;
    }


    /**
     * Gets the records_updated value for this CommonStatusType.
     * 
     * @return records_updated
     */
    public java.lang.Integer getRecords_updated() {
        return records_updated;
    }


    /**
     * Sets the records_updated value for this CommonStatusType.
     * 
     * @param records_updated
     */
    public void setRecords_updated(java.lang.Integer records_updated) {
        this.records_updated = records_updated;
    }


    /**
     * Gets the detail value for this CommonStatusType.
     * 
     * @return detail
     */
    public java.lang.String getDetail() {
        return detail;
    }


    /**
     * Sets the detail value for this CommonStatusType.
     * 
     * @param detail
     */
    public void setDetail(java.lang.String detail) {
        this.detail = detail;
    }


    /**
     * Gets the warning value for this CommonStatusType.
     * 
     * @return warning
     */
    public java.lang.String getWarning() {
        return warning;
    }


    /**
     * Sets the warning value for this CommonStatusType.
     * 
     * @param warning
     */
    public void setWarning(java.lang.String warning) {
        this.warning = warning;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CommonStatusType)) return false;
        CommonStatusType other = (CommonStatusType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.success==null && other.getSuccess()==null) || 
             (this.success!=null &&
              this.success.equals(other.getSuccess()))) &&
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            ((this.records_read==null && other.getRecords_read()==null) || 
             (this.records_read!=null &&
              this.records_read.equals(other.getRecords_read()))) &&
            ((this.records_failed==null && other.getRecords_failed()==null) || 
             (this.records_failed!=null &&
              this.records_failed.equals(other.getRecords_failed()))) &&
            ((this.records_deleted==null && other.getRecords_deleted()==null) || 
             (this.records_deleted!=null &&
              this.records_deleted.equals(other.getRecords_deleted()))) &&
            ((this.records_returned==null && other.getRecords_returned()==null) || 
             (this.records_returned!=null &&
              this.records_returned.equals(other.getRecords_returned()))) &&
            ((this.records_inserted==null && other.getRecords_inserted()==null) || 
             (this.records_inserted!=null &&
              this.records_inserted.equals(other.getRecords_inserted()))) &&
            ((this.records_updated==null && other.getRecords_updated()==null) || 
             (this.records_updated!=null &&
              this.records_updated.equals(other.getRecords_updated()))) &&
            ((this.detail==null && other.getDetail()==null) || 
             (this.detail!=null &&
              this.detail.equals(other.getDetail()))) &&
            ((this.warning==null && other.getWarning()==null) || 
             (this.warning!=null &&
              this.warning.equals(other.getWarning())));
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
        if (getSuccess() != null) {
            _hashCode += getSuccess().hashCode();
        }
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        if (getRecords_read() != null) {
            _hashCode += getRecords_read().hashCode();
        }
        if (getRecords_failed() != null) {
            _hashCode += getRecords_failed().hashCode();
        }
        if (getRecords_deleted() != null) {
            _hashCode += getRecords_deleted().hashCode();
        }
        if (getRecords_returned() != null) {
            _hashCode += getRecords_returned().hashCode();
        }
        if (getRecords_inserted() != null) {
            _hashCode += getRecords_inserted().hashCode();
        }
        if (getRecords_updated() != null) {
            _hashCode += getRecords_updated().hashCode();
        }
        if (getDetail() != null) {
            _hashCode += getDetail().hashCode();
        }
        if (getWarning() != null) {
            _hashCode += getWarning().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CommonStatusType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "CommonStatusType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("success");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "success"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("records_read");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "records_read"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("records_failed");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "records_failed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("records_deleted");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "records_deleted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("records_returned");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "records_returned"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("records_inserted");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "records_inserted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("records_updated");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "records_updated"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("detail");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "detail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("warning");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "warning"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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

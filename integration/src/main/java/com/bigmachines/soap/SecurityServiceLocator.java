/**
 * SecurityServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bigmachines.soap;

public class SecurityServiceLocator extends org.apache.axis.client.Service implements com.bigmachines.soap.SecurityService {

    public SecurityServiceLocator() {
    }


    public SecurityServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SecurityServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SecurityServicePort
    private java.lang.String SecurityServicePort_address = "https://partnertrn-osc-022.bigmachines.com/v1_0/receiver";

    public java.lang.String getSecurityServicePortAddress() {
        return SecurityServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SecurityServicePortWSDDServiceName = "SecurityServicePort";

    public java.lang.String getSecurityServicePortWSDDServiceName() {
        return SecurityServicePortWSDDServiceName;
    }

    public void setSecurityServicePortWSDDServiceName(java.lang.String name) {
        SecurityServicePortWSDDServiceName = name;
    }

    public com.bigmachines.soap.SecurityServicePortType getSecurityServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SecurityServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSecurityServicePort(endpoint);
    }

    public com.bigmachines.soap.SecurityServicePortType getSecurityServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.bigmachines.soap.SecurityServiceBindingStub _stub = new com.bigmachines.soap.SecurityServiceBindingStub(portAddress, this);
            _stub.setPortName(getSecurityServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSecurityServicePortEndpointAddress(java.lang.String address) {
        SecurityServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.bigmachines.soap.SecurityServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.bigmachines.soap.SecurityServiceBindingStub _stub = new com.bigmachines.soap.SecurityServiceBindingStub(new java.net.URL(SecurityServicePort_address), this);
                _stub.setPortName(getSecurityServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SecurityServicePort".equals(inputPortName)) {
            return getSecurityServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:soap.bigmachines.com", "SecurityService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "SecurityServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SecurityServicePort".equals(portName)) {
            setSecurityServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

/**
 * SecurityServiceBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bigmachines.soap;

import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;

import org.apache.axis.message.SOAPHeaderElement;


public class SecurityServiceBindingStub extends org.apache.axis.client.Stub implements com.bigmachines.soap.SecurityServicePortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[4];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "getUserInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">getUserInfo"), java.lang.Object.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">getUserInfoResponse"));
        oper.setReturnClass(com.bigmachines.soap.GetUserInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "getUserInfoResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:soap.bigmachines.com", "fault"),
                      "com.bigmachines.soap.Fault",
                      new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">fault"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("login");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">login"), com.bigmachines.soap.Login.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">loginResponse"));
        oper.setReturnClass(com.bigmachines.soap.LoginResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "loginResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:soap.bigmachines.com", "fault"),
                      "com.bigmachines.soap.Fault",
                      new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">fault"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("logout");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "logout"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">logout"), java.lang.Object.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">logoutResponse"));
        oper.setReturnClass(com.bigmachines.soap.LogoutResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "logoutResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:soap.bigmachines.com", "fault"),
                      "com.bigmachines.soap.Fault",
                      new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">fault"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setSessionCurrency");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "setSessionCurrency"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">setSessionCurrency"), com.bigmachines.soap.SetSessionCurrency.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">setSessionCurrencyResponse"));
        oper.setReturnClass(com.bigmachines.soap.SetSessionCurrencyResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "setSessionCurrencyResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:soap.bigmachines.com", "fault"),
                      "com.bigmachines.soap.Fault",
                      new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">fault"), 
                      true
                     ));
        _operations[3] = oper;

    }

    public SecurityServiceBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public SecurityServiceBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public SecurityServiceBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", ">mustUnderstand");
            cachedSerQNames.add(qName);
            cls = boolean.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">>UserType>group_list>group");
            cachedSerQNames.add(qName);
            cls = com.bigmachines.soap.UserTypeGroup_listGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">fault");
            cachedSerQNames.add(qName);
            cls = com.bigmachines.soap.Fault.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">getUserInfo");
            cachedSerQNames.add(qName);
            cls = java.lang.Object.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(null);
            cachedDeserFactories.add(simpledf);

            qName = new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">getUserInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.bigmachines.soap.GetUserInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">login");
            cachedSerQNames.add(qName);
            cls = com.bigmachines.soap.Login.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">loginResponse");
            cachedSerQNames.add(qName);
            cls = com.bigmachines.soap.LoginResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">logout");
            cachedSerQNames.add(qName);
            cls = java.lang.Object.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(null);
            cachedDeserFactories.add(simpledf);

            qName = new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">logoutResponse");
            cachedSerQNames.add(qName);
            cls = com.bigmachines.soap.LogoutResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">setSessionCurrency");
            cachedSerQNames.add(qName);
            cls = com.bigmachines.soap.SetSessionCurrency.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">setSessionCurrencyResponse");
            cachedSerQNames.add(qName);
            cls = com.bigmachines.soap.SetSessionCurrencyResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">UserType>group_list");
            cachedSerQNames.add(qName);
            cls = com.bigmachines.soap.UserTypeGroup_listGroup[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">>UserType>group_list>group");
            qName2 = new javax.xml.namespace.QName("urn:soap.bigmachines.com", "group");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:soap.bigmachines.com", "BooleanOrBlank");
            cachedSerQNames.add(qName);
            cls = com.bigmachines.soap.BooleanOrBlank.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("urn:soap.bigmachines.com", "CommonStatusType");
            cachedSerQNames.add(qName);
            cls = com.bigmachines.soap.CommonStatusType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:soap.bigmachines.com", "LoginRequestUserInfoType");
            cachedSerQNames.add(qName);
            cls = com.bigmachines.soap.LoginRequestUserInfoType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:soap.bigmachines.com", "LoginResponseUserInfo");
            cachedSerQNames.add(qName);
            cls = com.bigmachines.soap.LoginResponseUserInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:soap.bigmachines.com", "NotificationPreferenceType");
            cachedSerQNames.add(qName);
            cls = com.bigmachines.soap.NotificationPreferenceType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:soap.bigmachines.com", "UserType");
            cachedSerQNames.add(qName);
            cls = com.bigmachines.soap.UserType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.bigmachines.soap.GetUserInfoResponse getUserInfo(java.lang.Object getUserInfo) throws java.rmi.RemoteException, com.bigmachines.soap.Fault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getUserInfo"));
        cusSOAPHeader(_call,true,getUserInfo.toString());
        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getUserInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.bigmachines.soap.GetUserInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.bigmachines.soap.GetUserInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.bigmachines.soap.GetUserInfoResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.bigmachines.soap.Fault) {
              throw (com.bigmachines.soap.Fault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.bigmachines.soap.LoginResponse login(com.bigmachines.soap.Login login) throws java.rmi.RemoteException, com.bigmachines.soap.Fault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "login"));
        
       
        cusSOAPHeader(_call,false,"");

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {login});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.bigmachines.soap.LoginResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.bigmachines.soap.LoginResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.bigmachines.soap.LoginResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.bigmachines.soap.Fault) {
              throw (com.bigmachines.soap.Fault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.bigmachines.soap.LogoutResponse logout(java.lang.Object logout) throws java.rmi.RemoteException, com.bigmachines.soap.Fault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "logout"));
    
        cusSOAPHeader(_call,true,logout.toString());
        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {logout});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.bigmachines.soap.LogoutResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.bigmachines.soap.LogoutResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.bigmachines.soap.LogoutResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.bigmachines.soap.Fault) {
              throw (com.bigmachines.soap.Fault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.bigmachines.soap.SetSessionCurrencyResponse setSessionCurrency(com.bigmachines.soap.SetSessionCurrency setSessionCurrency) throws java.rmi.RemoteException, com.bigmachines.soap.Fault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "setSessionCurrency"));
        //cusSOAPHeader(_call,true);
        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {setSessionCurrency});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.bigmachines.soap.SetSessionCurrencyResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.bigmachines.soap.SetSessionCurrencyResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.bigmachines.soap.SetSessionCurrencyResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.bigmachines.soap.Fault) {
              throw (com.bigmachines.soap.Fault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    private org.apache.axis.client.Call cusSOAPHeader(org.apache.axis.client.Call call,boolean addSessionID,String SessionID)
    {
    	   try {
           	SOAPHeaderElement sec = new  SOAPHeaderElement("urn:soap.bigmachines.com", "bm:category");
           	
           	sec.addTextNode("Security");
           	
               SOAPHeaderElement xsdInfo = new  SOAPHeaderElement("urn:soap.bigmachines.com", "bm:xsdInfo");
               
               SOAPElement node=xsdInfo.addChildElement("bm:schemaLocation");
               node.addTextNode("https://partnertrn-osc-022.bigmachines.com/bmfsweb/partnertrn-osc-022/schema/v1_0/security/Security.xsd");

   			
   			
               call.addHeader(sec);
               call.addHeader(xsdInfo);
               if (addSessionID)
               {
            	   SOAPHeaderElement userInfo = new  SOAPHeaderElement("urn:soap.bigmachines.com", "bm:userInfo");
                   
                   SOAPElement sessionidNode=userInfo.addChildElement("bm:sessionId");
                   sessionidNode.addTextNode(SessionID);       			
                   call.addHeader(userInfo);

            	   
               }
   		} catch (SOAPException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
    	
    	return call;
    }
}

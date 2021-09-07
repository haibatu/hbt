

package com.hbt.common.iom.webservice;

public class IOM4AbilitySupportService_ServiceLocator extends org.apache.axis.client.Service implements IOM4AbilitySupportService_Service {

    public IOM4AbilitySupportService_ServiceLocator() {
    }


    public IOM4AbilitySupportService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IOM4AbilitySupportService_ServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for IOM4AbilitySupportService
    //
    /** test */
    //private static String IOM4AbilitySupportService_address = "http://132.80.243.9:9991/services/IOM4AbilitySupportService?wsdl";
    /** prod */
    private static String IOM4AbilitySupportService_address = "http://132.78.140.90:9961/services/IOM4AbilitySupportService?wsdl";
    @Override
    public String getIOM4AbilitySupportServiceAddress() {
        return IOM4AbilitySupportService_address;
    }

    // The WSDD service name defaults to the port name.
    private String IOM4AbilitySupportServiceWSDDServiceName = "IOM4AbilitySupportService";

    public String getIOM4AbilitySupportServiceWSDDServiceName() {
        return IOM4AbilitySupportServiceWSDDServiceName;
    }

    public void setIOM4AbilitySupportServiceWSDDServiceName(String name) {
        IOM4AbilitySupportServiceWSDDServiceName = name;
    }

    @Override
    public IOM4AbilitySupportService_PortType getIOM4AbilitySupportService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IOM4AbilitySupportService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIOM4AbilitySupportService(endpoint);
    }

    @Override
    public IOM4AbilitySupportService_PortType getIOM4AbilitySupportService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            IOM4AbilitySupportServiceSoapBindingStub _stub = new IOM4AbilitySupportServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getIOM4AbilitySupportServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIOM4AbilitySupportServiceEndpointAddress(String address) {
        IOM4AbilitySupportService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @Override
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (IOM4AbilitySupportService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                IOM4AbilitySupportServiceSoapBindingStub _stub = new IOM4AbilitySupportServiceSoapBindingStub(new java.net.URL(IOM4AbilitySupportService_address), this);
                _stub.setPortName(getIOM4AbilitySupportServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @Override
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("IOM4AbilitySupportService".equals(inputPortName)) {
            return getIOM4AbilitySupportService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    @Override
    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:http://132.78.140.90:9961/services/IOM4AbilitySupportService", "IOM4AbilitySupportService");
    }

    private java.util.HashSet ports = null;

    @Override
    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:http://132.78.140.90:9961/services/IOM4AbilitySupportService", "IOM4AbilitySupportService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("IOM4AbilitySupportService".equals(portName)) {
            setIOM4AbilitySupportServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

package com.hbt.project.ability.service.impl;
import com.hbt.project.ability.service.IOM4WebService;
import lombok.extern.slf4j.Slf4j;
import org.apache.axis.AxisFault;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

@Service
@Slf4j
public class IOM4WebServiceImpl implements IOM4WebService {

    @Value("${api.iom.check.platformQry.functName}")
    String platformQryFunctName = "";

    @Value("${api.iom.check.platformQry.url}")
    String platformQryUrl = "";

    @Value("${api.iom.check.platformOperator.functName}")
    String platformOperatorFunctName = "";

    @Value("${api.iom.check.platformOperator.url}")
    String platformOperatorUrl = "";

    /**
     * 查询接口
     * @return
     */
    @Override
    public String platformQry() {
//        try{
//            IOM4AbilitySupportService_ServiceLocator service = new IOM4AbilitySupportService_ServiceLocator();
//            service.setIOM4AbilitySupportServiceEndpointAddress(platformQryUrl);
//            IOM4AbilitySupportServiceSoapBindingStub stub = new IOM4AbilitySupportServiceSoapBindingStub(new URL(platformQryUrl), service);
//            String resultXml = stub.svcCallIOM(platformQryFunctName, generateXmlHeader(), genernateXmlBody(startTime,adslNumber,netCode, brandCode, code, userName,rate,serialNumber,staffName));
//
//        } catch (AxisFault axisFault) {
//            axisFault.printStackTrace();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
        return null;

    }


    /**
     * 操作接口
     * @return
     */
    @Override

    public String platformOperator() {
//        try{
//            IOM4AbilitySupportService_ServiceLocator service = new IOM4AbilitySupportService_ServiceLocator();
//            service.setIOM4AbilitySupportServiceEndpointAddress(platformOperatorUrl);
//            IOM4AbilitySupportServiceSoapBindingStub stub = new IOM4AbilitySupportServiceSoapBindingStub(new java.net.URL(platformOperatorUrl), service);
//            String resultXml = stub.svcCallIOM(platformOperatorFunctName, generateXmlHeader(), genernateXmlBody(startTime,adslNumber,netCode, brandCode, code, userName,rate,serialNumber,staffName));
//
//        } catch (AxisFault axisFault) {
//            axisFault.printStackTrace();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
        return null;
    }

}

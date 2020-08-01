package com.g0818.controller.nbcontroller;

import com.iotplatform.client.dto.*;
import com.iotplatform.client.invokeapi.PushMessageReceiver;

public class MessagePush extends PushMessageReceiver {


    public MessagePush() {
        super();
    }

    @Override
    public void handleBody(String body) {
        super.handleBody(body);
    }

    @Override
    public void handleDeviceAdded(NotifyDeviceAddedDTO body) {
        super.handleDeviceAdded(body);
    }

    @Override
    public void handleBindDevice(NotifyBindDeviceDTO body) {
        super.handleBindDevice(body);
    }

    @Override
    public void handleDeviceInfoChanged(NotifyDeviceInfoChangedDTO body) {
        super.handleDeviceInfoChanged(body);
    }

    @Override
    public void handleDeviceDataChanged(NotifyDeviceDataChangedDTO body) {
        super.handleDeviceDataChanged(body);
    }

    @Override
    public void handleDeviceDatasChanged(NotifyDeviceDatasChangedDTO body) {
        super.handleDeviceDatasChanged(body);
    }

    @Override
    public void handleServiceInfoChanged(NotifyServiceInfoChangedDTO body) {
        super.handleServiceInfoChanged(body);
    }

    @Override
    public void handleDeviceDeleted(NotifyDeviceDeletedDTO body) {
        super.handleDeviceDeleted(body);
    }

    @Override
    public void handleMessageConfirm(NotifyMessageConfirmDTO body) {
        super.handleMessageConfirm(body);
    }

    @Override
    public void handleCommandRsp(NotifyCommandRspDTO body) {
        super.handleCommandRsp(body);
    }

    @Override
    public void handleDeviceEvent(NotifyDeviceEventDTO body) {
        super.handleDeviceEvent(body);
    }

    @Override
    public void handleDeviceModelAdded(NotifyDeviceModelAddedDTO body) {
        super.handleDeviceModelAdded(body);
    }

    @Override
    public void handleDeviceModelDeleted(NotifyDeviceModelDeletedDTO body) {
        super.handleDeviceModelDeleted(body);
    }

    @Override
    public void handleRuleEvent(NotifyRuleEventDTO body) {
        super.handleRuleEvent(body);
    }

    @Override
    public void handleDeviceDesiredStatusChanged(NotifyDeviceDesiredStatusChangedDTO body) {
        super.handleDeviceDesiredStatusChanged(body);
    }

    @Override
    public void handleSwUpgradeStateChanged(NotifySwUpgradeStateChangedDTO body) {
        super.handleSwUpgradeStateChanged(body);
    }

    @Override
    public void handleSwUpgradeResult(NotifySwUpgradeResultDTO body) {
        super.handleSwUpgradeResult(body);
    }

    @Override
    public void handleFwUpgradeStateChanged(NotifyFwUpgradeStateChangedDTO body) {
        super.handleFwUpgradeStateChanged(body);
    }

    @Override
    public void handleFwUpgradeResult(NotifyFwUpgradeResultDTO body) {
        super.handleFwUpgradeResult(body);
    }

    @Override
    public void handleNBCommandStateChanged(NotifyNBCommandStatusChangedDTO body) {
        super.handleNBCommandStateChanged(body);
    }
}

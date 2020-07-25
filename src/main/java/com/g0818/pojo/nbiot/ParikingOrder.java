package com.g0818.pojo.nbiot;

public class ParikingOrder {


		private Integer	id;								//ID号
		private String  OrderNumber;				//订单号
		private String  AmountOfMoney;			//应付款金额
		private String parkingLockNo;				//车位锁号
		private String cmdState;						//开锁命令下发状态
		private boolean state;							//支付状态
		
		

		public ParikingOrder(Integer id, String orderNumber, String amountOfMoney, String parkingLockNo,
				boolean state) {
			super();
			this.id = id;
			OrderNumber = orderNumber;
			AmountOfMoney = amountOfMoney;
			this.parkingLockNo = parkingLockNo;
			this.state = state;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getOrderNumber() {
			return OrderNumber;
		}
		public void setOrderNumber(String orderNumber) {
			OrderNumber = orderNumber;
		}
		public String getAmountOfMoney() {
			return AmountOfMoney;
		}
		public void setAmountOfMoney(String amountOfMoney) {
			AmountOfMoney = amountOfMoney;
		}
		public String getParkingLockNo() {
			return parkingLockNo;
		}
		public void setParkingLockNo(String parkingLockNo) {
			this.parkingLockNo = parkingLockNo;
		}
		public boolean isState() {
			return state;
		}
		public void setState(boolean state) {
			this.state = state;
		}
		
		public String getCmdState() {
			return cmdState;
		}
		public void setCmdState(String cmdState) {
			this.cmdState = cmdState;
		}

		
}
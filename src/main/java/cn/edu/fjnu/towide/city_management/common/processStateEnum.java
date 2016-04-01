package cn.edu.fjnu.towide.city_management.common;

public enum processStateEnum {
	
	/**
	 * 枚举常量必须要写在类开始的位置,不然会报错 删除、无效、待审核未反馈、待审核反馈、正在处理、已结案 0 1 2 3 4 5
	 */

    DELETE(0), //删除状态
    NVALID(1),//无效状态
    PENDING_UNFEEDBACK(2),//待审核未反馈
    PENDING_FEEDBACK(3),//待审核反馈
    DISPOSING(4),//正在处理
    ENDCASE(5);//已结案
    
     private String stringValue;  
     private int intVlue;  
       
     //构造函数必须为private的,防止意外调用  
     private processStateEnum(String stringValue){  
         this.stringValue = stringValue;  
     }  
       
     //构造函数必须为private的,防止意外调用  
     private processStateEnum(int intVlue){  
         this.intVlue = intVlue;  
     }  
  
    public String getStringValue() {  
        return stringValue;  
    }  
  
    public int getIntVlue() {  
        return intVlue;  
    }
	
	

}

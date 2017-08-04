import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Report {

	public static int trigger = 0;
	
	public void query_for_report_spb() {// �� ������ ��� - �� � �� � �������
		
		
		long curTime = System.currentTimeMillis();
		String StringDateTime_sign = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(curTime
				- (Experr.days_signal*24*60*60000 
				 + Experr.hours_signal));

		String StringDateTime_pay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(curTime
				- (Experr.days_pay*24*60*60000 
				 + Experr.hours_pay));

		BD_write bdw = new BD_write();
		bdw.connect();
		Loging log = new Loging();
		log.logtext("����� �����. ");
		
//***���*****************************************************************************************************************************		
		String query = "call report_sig ('" + StringDateTime_sign + "', 1, 0, 0)";//***�������� report ������(���, ��, ���)(1,0,0)
		try {																						//*****************************
			bdw.report_spb(query,1);
		} catch (ClassNotFoundException e) {
		}		
		String query11 = "call report_cash ('" + StringDateTime_sign + "', 1, 0, 0)";//***�������� report ������
		try {
			bdw.report_spb(query11,2);
		} catch (ClassNotFoundException e) {
		}				
		String query111 = "call report_pay ('" + StringDateTime_sign + "', '" + StringDateTime_pay + "', 1, 0, 0)";//***�������� ����
		try {
			bdw.report_spb(query111,3);
		} catch (ClassNotFoundException e) {
		}

		Experr.table_2.updateUI();
		Experr.table_2.revalidate();
		Experr.table_2.repaint();
		Experr.model_spb.fireTableDataChanged();
//***********************************************************************************************************************************		
//*******��************************************************************************************************************************		
		String query2 = "call report_sig ('" + StringDateTime_sign + "', 0, 1, 0)";//***�������� report ������
		try {
			bdw.report_lo(query2,1);
		} catch (ClassNotFoundException e) {
		}
		
		String query22 = "call report_cash ('" + StringDateTime_sign + "', 0, 1, 0)";//***�������� report ������
		try {
			bdw.report_lo(query22,2);
		} catch (ClassNotFoundException e) {
		}
		
		
		String query222 = "call report_pay ('" + StringDateTime_sign + "', '" + StringDateTime_pay + "', 0, 1, 0)";//***�������� ������
		try {
			bdw.report_lo(query222,3);
		} catch (ClassNotFoundException e) {
		}
		Experr.table_3.updateUI();
		Experr.table_3.revalidate();
		Experr.table_3.repaint();
		Experr.model_lo.fireTableDataChanged();
//*********************************************************************************************************************************		
//******�������********************************************************************************************************************		
		
		String query3 = "call report_sig ('" + StringDateTime_sign + "', 0, 0, 1)";//***�������� report ������
		try {
			bdw.report_reg(query3,1);
		} catch (ClassNotFoundException e) {
		}
		
		String query33 = "call report_cash ('" + StringDateTime_sign + "', 0, 0, 1)";//***�������� report ������
		try {
			bdw.report_reg(query33,2);
		} catch (ClassNotFoundException e) {
		}
		
		
		String query333 = "call report_pay ('" + StringDateTime_sign + "', '" + StringDateTime_pay + "', 0, 0, 1)";//***�������� ����
		try {
			bdw.report_reg(query333,3);
		} catch (ClassNotFoundException e) {
		}
		Experr.table_4.updateUI();
		Experr.table_4.revalidate();
		Experr.table_4.repaint();
		Experr.model_reg.fireTableDataChanged();
//*********************************************************************************************************************************		
		bdw.close_connect();
		log.logtext("Сформировал отчёт. ");
		
	}
	
	public String [] edit_row (String [] row, int trig){

		if (trig == 1){row[3]="сигнал";}
		if (trig == 3){row[3]="нет платежей";}
		
			if ( row[5] == null){ row[5] = "";}//*******защита от нуль поинт екзепшн		
				switch (row[5]) {
					case "": row[5]="не успел"; break;	//***���� �� ����� ���� ��� ���������	
				}
		
		return row;
		
	}
	
}

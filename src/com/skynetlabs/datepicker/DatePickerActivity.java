package com.skynetlabs.datepicker;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;

public class DatePickerActivity extends Activity {
	private Button buttonSelectDate;

	private int year;
	private int month;
	private int day;

	static final int DATE_DIALOG_ID = 999;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_datepicker);

		// setCurrentDateOnView();
		addListenerOnButton();
	} // end method onCreate

	public void addListenerOnButton() {
		buttonSelectDate = (Button) findViewById(R.id.buttonSelectDate);

		buttonSelectDate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {

				showDialog(DATE_DIALOG_ID);

			} // end method onClick
		}); // end OnClickListener
	} // end method addListenerOnButton

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
			// set date picker as current date
			final Calendar c = Calendar.getInstance();
			year = c.get(Calendar.YEAR);
			month = c.get(Calendar.MONTH);
			day = c.get(Calendar.DAY_OF_MONTH);
			return new DatePickerDialog(this, datePickerListener, year, month, day);
		} // end switch
		return null;
	} // end method onCreateDialog

	private final DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
		// when the dialog box is closed, then the method below will be called.
		@Override
		public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {

		} // end method onDateSet
	}; // end OnDateSetListener
} // end Class DatePickerActivity

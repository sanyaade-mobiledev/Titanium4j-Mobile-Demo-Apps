package com.emitrom.ti4j.locancalculator.client.ui.calculate;

import com.emitrom.gwt4.ti.mobile.client.Titanium;
import com.emitrom.gwt4.ti.mobile.client.api.API;
import com.emitrom.gwt4.ti.mobile.client.app.App;
import com.emitrom.gwt4.ti.mobile.client.core.Timer;
import com.emitrom.gwt4.ti.mobile.client.core.events.TiEvent;
import com.emitrom.gwt4.ti.mobile.client.core.events.ui.InteractionEvent;
import com.emitrom.gwt4.ti.mobile.client.core.events.ui.dialog.DialogClickEvent;
import com.emitrom.gwt4.ti.mobile.client.core.events.ui.slider.SliderEvent;
import com.emitrom.gwt4.ti.mobile.client.core.events.ui.text.TextEvent;
import com.emitrom.gwt4.ti.mobile.client.core.handlers.ui.DialogClickHandler;
import com.emitrom.gwt4.ti.mobile.client.core.handlers.ui.InteractionHandler;
import com.emitrom.gwt4.ti.mobile.client.core.handlers.ui.SliderChangeHandler;
import com.emitrom.gwt4.ti.mobile.client.core.handlers.ui.TextHandler;
import com.emitrom.gwt4.ti.mobile.client.platform.Platform;
import com.emitrom.gwt4.ti.mobile.client.ui.Button;
import com.emitrom.gwt4.ti.mobile.client.ui.ImageView;
import com.emitrom.gwt4.ti.mobile.client.ui.Label;
import com.emitrom.gwt4.ti.mobile.client.ui.OptionDialog;
import com.emitrom.gwt4.ti.mobile.client.ui.Slider;
import com.emitrom.gwt4.ti.mobile.client.ui.TextField;
import com.emitrom.gwt4.ti.mobile.client.ui.UI;
import com.emitrom.gwt4.ti.mobile.client.ui.View;
import com.emitrom.gwt4.ti.mobile.client.ui.iphone.SystemButton;
import com.emitrom.gwt4.ti.mobile.client.ui.style.Color;
import com.emitrom.gwt4.ti.mobile.client.ui.style.Font;
import com.emitrom.gwt4.ti.mobile.client.ui.style.FontWeight;
import com.emitrom.ti4j.locancalculator.client.common.ChartValueHolder;
import com.emitrom.ti4j.locancalculator.client.ui.MainTabGroup;
import com.emitrom.ti4j.locancalculator.client.ui.settings.SettingsView;

/**
 * MainView of the loan calculator
 *
 */
public class CalculateView extends View {

	private final static CalculateView INSTANCE = new CalculateView();
	private int numberMonths = 36;
	private double interestRate = 6.0;
	private TextField amountTextField;
	private TextField interestRateTextField;
	private Label interstRateLabel;
	private Label amountLabel;
	private Slider lengthSlider;
	private Label loanLengthLabel;
	private double totalInterest;
	private double totalRepayments;
	
	public static CalculateView get(){
		return INSTANCE;
	}
	
	private CalculateView(){
		this.setWidth(300);
		this.setHeight(480 - 130);
		this.setLeft(10);
		this.setTop(10);
		this.setBackgroundColor(new Color("#FFF"));
		this.setBorderRadius(5);
		
		ImageView logo = new ImageView();
		logo.setImage("assets/logo.png");
		logo.setWidth(253);
		logo.setHeight(96);
		logo.setLeft((300 - 253) / 2);
		logo.setTop(0);
		this.add(logo);
		
		amountLabel = new Label("Loan amount : $");
		amountLabel.setWidth("auto");
		amountLabel.setHeight(30);
		amountLabel.setTop(100);
		amountLabel.setLeft(20);
		amountLabel.setFont(new Font(14, "Helvetica", FontWeight.BOLD));
		this.add(amountLabel);
		
		
		interstRateLabel = new Label("Interest Rate : $");
		interstRateLabel.setWidth("auto");
		interstRateLabel.setHeight(30);
		interstRateLabel.setTop(150);
		interstRateLabel.setLeft(20);
		interstRateLabel.setFont(new Font(14, "Helvetica", FontWeight.BOLD));
		this.add(interstRateLabel);
		
		
		loanLengthLabel = new Label("Loan length (" + numberMonths + " months) :");
		loanLengthLabel.setWidth(100);
		loanLengthLabel.setHeight("auto");
		loanLengthLabel.setTop(200);
		loanLengthLabel.setLeft(20);
		loanLengthLabel.setFont(new Font(14, "Helvetica", FontWeight.BOLD));
		this.add(loanLengthLabel);
		
		
		
		//iOS only
		Button flexSpace = new Button();
		flexSpace.setSystemButton(SystemButton.FLEXIBLE_SPACE);
		
		Button doneButton = new Button();
	    doneButton.setSystemButton(SystemButton.DONE);
		doneButton.setBottom(0);
		doneButton.addClickHandler(new InteractionHandler() {
			@Override
			public void onClick(InteractionEvent event) {
				amountTextField.blur();
				interestRateTextField.blur();
				interestRateTextField.setTop(150);
				interstRateLabel.setTop(150);
				interestRate = Double.valueOf(interestRateTextField.getValue());
				amountTextField.setVisible(true);
				amountLabel.setVisible(true);
			}
		});
		
		
		amountTextField = new TextField();
		amountTextField.setHeight(30);
		amountTextField.setWidth(140);
		amountTextField.setTop(100);
		amountTextField.setRight(20);
		amountTextField.setBorderStyle(UI.INPUT_BORDERSTYLE_ROUNDED);
		amountTextField.setReturnKeyType(UI.RETURNKEY_DONE);
		amountTextField.setHintText("1000.00");
		amountTextField.setKeyboardType(UI.KEYBOARD_PHONE_PAD);
		amountTextField.setKeyboardToolbar(flexSpace, doneButton);
		this.add(amountTextField);
		
		
		interestRateTextField = new TextField();
		interestRateTextField.setHeight(30);
		interestRateTextField.setWidth(140);
		interestRateTextField.setTop(150);
		interestRateTextField.setRight(20);
		interestRateTextField.setBorderStyle(UI.INPUT_BORDERSTYLE_ROUNDED);
		interestRateTextField.setReturnKeyType(UI.RETURNKEY_DONE);
		interestRateTextField.setKeyboardType(UI.KEYBOARD_PHONE_PAD);
		interestRateTextField.setKeyboardToolbar(flexSpace,doneButton);
		interestRateTextField.setValue(Double.toString(interestRate));
		
		//if the interest rate field textfield is focused change its top value so we can see it
		//  only for the iphone platform though
		interestRateTextField.addFocusHandler(new TextHandler() {
			@Override
			public void onEvent(TextEvent event) {
				if(Platform.get().getOsname().equalsIgnoreCase("iphone")){
					interestRateTextField.setTop(100);
					interstRateLabel.setTop(100);
					amountLabel.setVisible(false);
					amountTextField.setVisible(false);
				}
			}
		});
		this.add(interestRateTextField);
		
		lengthSlider = new Slider();
		lengthSlider.setWidth(140);
		lengthSlider.setTop(200);
		lengthSlider.setRight(20);
		lengthSlider.setMin(12);
		lengthSlider.setMax(60);
		lengthSlider.setValue(numberMonths);
		lengthSlider.setThumbImage("assets/sliderThumb.png");
		lengthSlider.setSelectedThumbImage("assets/sliderThumbSelected.png");
		lengthSlider.setHighlightedThumbImage("assets/sliderThumbSelected.png");
		lengthSlider.addChangeHandler(new SliderChangeHandler() {
			@Override
			public void onChange(SliderEvent event) {
				API.get().info(Double.toString(lengthSlider.getValue()));
				numberMonths = (int)Math.round(lengthSlider.getValue());
				loanLengthLabel.setText("Loan length (" + numberMonths + " months) :");
			}
		});
		this.add(lengthSlider);
		
		//calculate interest
		Button calculateBtn = new Button("", new InteractionHandler() {
			@Override
			public void onClick(InteractionEvent event) {
				if(amountTextField.getValue().isEmpty() || amountTextField.getValue().equalsIgnoreCase("") || amountTextField.getValue() == null){
					Titanium.alert("Loan Calculator", "Please enter the loan amount");
				}else{
					double amount = Double.valueOf(amountTextField.getValue());
					double totalInterest = (amount * (interestRate / 100) * numberMonths) / 12;
					API.get().info("Totalinterest :" + totalInterest);
					
					OptionDialog optionDialog = new OptionDialog();
					optionDialog.setTitle("Total interest on this loan equals to : " + Math.round(totalInterest) + " $");
					optionDialog.setOptions("Okay");
					optionDialog.show();
				}
				
				
			}
		});
		
		
		calculateBtn.setImage("assets/calculateInterestButton.png");
		calculateBtn.setTop(255);
		calculateBtn.setWidth(252);
		calculateBtn.setHeight(32);
		calculateBtn.setLeft(23);
		this.add(calculateBtn);
		
		//calculate payment
		calculateBtn = new Button("", new InteractionHandler() {
			

			@Override
			public void onClick(InteractionEvent event) {
				if(amountTextField.getValue().isEmpty() || amountTextField.getValue().equalsIgnoreCase("") || amountTextField.getValue() == null){
					Titanium.alert("Loan Calculator", "Please enter the loan amount");
				}else{
					double amount = Double.valueOf(amountTextField.getValue());
					totalInterest = (amount * (interestRate / 100) * numberMonths) / 12;
					totalRepayments = Math.round(amount) + totalInterest;
					API.get().info("Total Repayments : " + totalRepayments);
					processCalculation(totalRepayments);
				}
				
			}
		});
		calculateBtn.setImage("assets/calculateRepaymentsButton.png");
		calculateBtn.setTop(300);
		calculateBtn.setWidth(252);
		calculateBtn.setHeight(32);
		calculateBtn.setLeft(23);
		this.add(calculateBtn);
		
	}
	
	
	private void processCalculation(double value){
		if(SettingsView.get().isAutoShowChart()){
			openChartWindow();
		}else{
			OptionDialog optionDialog = new OptionDialog();
			optionDialog.setTitle("Total repayments on this loan equates to $" + value + ". Do you want to view  this on a chart ? ");
			optionDialog.setOptions("Okay", "No");
			optionDialog.addClickHandler(new DialogClickHandler() {
				@Override
				public void onClick(DialogClickEvent event) {
					int buttonIndex = event.getIndex();
					if(buttonIndex == 0){
						openChartWindow();
						SettingsView.get().setShowAutoChart();
					}
				}
			});
			optionDialog.setCancel(1);
			optionDialog.show();
		}
	
	}
	
	private void openChartWindow(){
		MainTabGroup.get().openChartWindow();
		new Timer() {
			@Override
			public void run() {
				TiEvent event = new TiEvent();
				event.setEventData(new ChartValueHolder(totalRepayments, totalInterest));
				App.get().fireEvent("loanEvent", event);
			}
		}.schedule(1000);
		
	}
}

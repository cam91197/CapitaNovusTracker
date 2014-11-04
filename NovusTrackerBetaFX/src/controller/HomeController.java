package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.MainApp;
import javafx.animation.TranslateTransitionBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class HomeController extends AnchorPane implements Initializable {

	@FXML PieChart novusPieChart;
	private MainApp application;
	
	public void setApp(MainApp application){
        this.application = application;
    }
	
	ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
			new PieChart.Data("Testers", 22), 
			new PieChart.Data("Developers", 32),
			new PieChart.Data("Business Analysts", 15));
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		novusPieChart.setData(pieChartData);
		
		for( PieChart.Data d : pieChartData ) {
			d.getNode().setOnMouseEntered(new MouseHoverAnimation(d,novusPieChart));
			d.getNode().setOnMouseExited(new MouseExitAnimation());
		}
		
		novusPieChart.setClockwise(false);
		
		
	}
	
	static class MouseHoverAnimation implements EventHandler<MouseEvent> {
		static final Duration ANIMATION_DURATION = new Duration(500);
		static final double ANIMATION_DISTANCE = 0.15;
		private double cos;
		private double sin;
		private PieChart chart;

		public MouseHoverAnimation(PieChart.Data d, PieChart chart) {
			this.chart = chart;
			double start = 0;
			double angle = calcAngle(d);
			for( PieChart.Data tmp : chart.getData() ) {
				if( tmp == d ) {
					break;
				}
				start += calcAngle(tmp);
			}
			
			cos = Math.cos(Math.toRadians(0 - start - angle / 2));
			sin = Math.sin(Math.toRadians(0 - start - angle / 2));
		}
		
		@Override
		public void handle(MouseEvent arg0) {
			Node n = (Node) arg0.getSource();
			
			double minX = Double.MAX_VALUE;
			double maxX = Double.MAX_VALUE * -1;
			
			for( PieChart.Data d : chart.getData() ) {
				minX = Math.min(minX, d.getNode().getBoundsInParent().getMinX());
				maxX = Math.max(maxX, d.getNode().getBoundsInParent().getMaxX());
			}
			
			double radius = maxX - minX;
			TranslateTransitionBuilder.create().toX((radius *  ANIMATION_DISTANCE) * cos).toY((radius *  ANIMATION_DISTANCE) * sin).duration(ANIMATION_DURATION).node(n).build().play();
		}
		
		private static double calcAngle(PieChart.Data d) {
			double total = 0;
			for( PieChart.Data tmp : d.getChart().getData() ) {
				total += tmp.getPieValue();
			}
			
			return 360 * (d.getPieValue() / total); 
		}
	}
	
	static class MouseExitAnimation implements EventHandler<MouseEvent> {
			@Override
			public void handle(MouseEvent event) {
				TranslateTransitionBuilder.create().toX(0).toY(0).duration(new Duration(500)).node((Node) event.getSource()).build().play();
			}
	}
	
	@FXML
	 private void logout(ActionEvent event)
	 {
		//application.gotoProfile();
		System.out.println("Logout Here");
	 }
	
	 

}

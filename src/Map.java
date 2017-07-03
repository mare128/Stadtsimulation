
public class Map extends File {
	private String[][] mapCarsArray;
	private String[] mapHousesArray;
	private int lengthCarsArray;
	private int widthCarsArray;
	private int lengthHousesArray;


// numeration starts with 0
	public Map(int lengthCars, int widthCars, int lengthHouses){
		mapCarsArray = new String[lengthCars][widthCars];
		mapHousesArray = new String[lengthHouses];
lengthCarsArray = lengthCars;
widthCarsArray = widthCars;
lengthHousesArray = lengthHouses;
		
	}
	
	public void createSmallHousesMap(){
		//write() content map
		
		writeHouses( 0,"street"); 
		writeHouses(1 ,"street"); 
		writeHouses( 2,"street"); 
		writeHouses( 3,"street"); 
		writeHouses(4 ,"street"); 
		writeHouses(5 ,"street"); 
		writeHouses(6 ,"street"); 
		writeHouses(7 ,"street"); 
		writeHouses(8 ,"street"); 
		writeHouses(17 ,"street"); 
		writeHouses( 18,"street"); 
		writeHouses(19 ,"street"); 
		writeHouses(20 ,"street"); 
		writeHouses(21 ,"street"); 
		writeHouses(22 ,"street"); 
		writeHouses(23 ,"street"); 
		writeHouses(51 ,"street"); 
		writeHouses(56 ,"street"); 
		writeHouses(65 ,"street"); 
		writeHouses(71 ,"street"); 
		writeHouses(99 ,"street"); 
		writeHouses(104 ,"street"); 
		writeHouses(113 ,"street"); 
		writeHouses(119 ,"street"); 
		writeHouses(120 ,"street"); 
		writeHouses(121 ,"street"); 
		writeHouses(122 ,"street"); 
		writeHouses(123 ,"street"); 
		writeHouses(147 ,"street"); 
		writeHouses(148 ,"street"); 
		writeHouses(149 ,"street"); 
		writeHouses(150 ,"street"); 
		writeHouses(151 ,"street"); 
		writeHouses(152 ,"street"); 
		writeHouses(153 ,"street"); 
		writeHouses(154 ,"street"); 
		writeHouses(155 ,"street"); 
		writeHouses(156 ,"street"); 
		writeHouses(157 ,"street"); 
		writeHouses(158 ,"street"); 
		writeHouses(159 ,"street"); 
		writeHouses(160 ,"street"); 
		writeHouses(161 ,"street"); 
		writeHouses(167 ,"street"); 
		writeHouses(197 ,"street"); 
		writeHouses(202 ,"street"); 
		writeHouses(209 ,"street"); 
		writeHouses(215 ,"street"); 
		writeHouses(245 ,"street"); 
		writeHouses(250 ,"street"); 
		writeHouses(257 ,"street"); 
		writeHouses(263 ,"street"); 
		writeHouses(288 ,"street"); 
		writeHouses(289 ,"street"); 
		writeHouses(290 ,"street"); 
		writeHouses(291 ,"street"); 
		writeHouses(292 ,"street"); 
		writeHouses(293 ,"street"); 
		writeHouses(294 ,"street"); 
		writeHouses(295 ,"street"); 
		writeHouses(296 ,"street"); 
		writeHouses(297 ,"street"); 
		writeHouses(298 ,"street"); 
		writeHouses(299 ,"street"); 
		writeHouses(300 ,"street"); 
		writeHouses(301 ,"street"); 
		writeHouses(302 ,"street"); 
		writeHouses(303 ,"street"); 
		writeHouses(304 ,"street"); 
		writeHouses(305 ,"street"); 
		writeHouses(306 ,"street"); 
		writeHouses(307 ,"street"); 
		writeHouses(308 ,"street"); 
		writeHouses(309 ,"street"); 
		writeHouses(310 ,"street"); 
		writeHouses(311 ,"street"); 
		writeHouses(312 ,"street"); 
		writeHouses(313 ,"street"); 
		writeHouses(314 ,"street"); 
		writeHouses(315 ,"street"); 
		writeHouses(343 ,"street"); 
		writeHouses(346 ,"street"); 
		writeHouses(350 ,"street"); 
		writeHouses(359 ,"street"); 
		writeHouses(391 ,"street"); 
		writeHouses(394 ,"street"); 
		writeHouses(398 ,"street"); 
		writeHouses(407 ,"street"); 
		writeHouses(439 ,"street"); 
		writeHouses(440 ,"street"); 
		writeHouses(441 ,"street"); 
		writeHouses(442 ,"street"); 
		writeHouses(446 ,"street"); 
		writeHouses(455 ,"street"); 
		writeHouses(482 ,"street"); 
		writeHouses(483 ,"street"); 
		writeHouses(484 ,"street"); 
		writeHouses(485 ,"street"); 
		writeHouses(486 ,"street"); 
		writeHouses(487 ,"street"); 
		writeHouses(490 ,"street"); 
		writeHouses(494 ,"street"); 
		writeHouses(495 ,"street"); 
		writeHouses(496 ,"street"); 
		writeHouses(497 ,"street"); 
		writeHouses(498 ,"street"); 
		writeHouses(499 ,"street"); 
		writeHouses(500 ,"street"); 
		writeHouses(501 ,"street"); 
		writeHouses(502 ,"street"); 
		writeHouses(503 ,"street"); 
		writeHouses(504 ,"street"); 
		writeHouses(505 ,"street"); 
		writeHouses(506 ,"street"); 
		writeHouses(507 ,"street"); 
		writeHouses(530 ,"street"); 
		writeHouses(535 ,"street"); 
		writeHouses(538 ,"street"); 
		writeHouses(539 ,"street"); 
		writeHouses(540 ,"street"); 
		writeHouses(541 ,"street"); 
		writeHouses(542 ,"street"); 
		writeHouses(547 ,"street"); 
		writeHouses(551 ,"street"); 
		writeHouses(578 ,"street"); 
		writeHouses(583 ,"street"); 
		writeHouses(584 ,"street"); 
		writeHouses(585 ,"street"); 
		writeHouses(586 ,"street"); 
		writeHouses(590 ,"street"); 
		writeHouses(595 ,"street"); 
		writeHouses(599 ,"street"); 
		writeHouses(624 ,"street"); 
		writeHouses(625 ,"street"); 
		writeHouses(626 ,"street"); 
		writeHouses(627 ,"street"); 
		writeHouses(628 ,"street"); 
		writeHouses(629 ,"street"); 
		writeHouses(630 ,"street"); 
		writeHouses(631 ,"street"); 
		writeHouses(634 ,"street"); 
		writeHouses(638 ,"street"); 
		writeHouses(639 ,"street"); 
		writeHouses(640 ,"street"); 
		writeHouses(641 ,"street"); 
		writeHouses(642 ,"street"); 
		writeHouses(643 ,"street"); 
		writeHouses(647 ,"street"); 
		writeHouses(679 ,"street"); 
		writeHouses(682 ,"street"); 
		writeHouses(691 ,"street"); 
		writeHouses(695, "street");
		writeHouses(727 ,"street"); 
		writeHouses(730 ,"street"); 
		writeHouses(739 ,"street"); 
		writeHouses(743, "street");
	}
	
	public void createMediumHousesMap(){
		//write() content map
	}

	public void createLargeMap(){
		//write() content map
		createSmallHousesMap();
		//writeHouses() content map
	}

	public void createLargeHousesMap(){
		createMediumHousesMap();
		//writeHouses() content map
	}


public String getCarsFromFile(int p1, int p2){
	return mapCarsArray[p1][p2];
}
public String getHousesFromFile(int position){
	return mapHousesArray[position];
}

public void writeHouses(int position, String content){
	mapHousesArray[position] = content;
}
public void writeCars(int p1, int p2, String content){
	mapCarsArray[p1][p2] = content;
}
public void setCarsMap(String[][] mapCars){
	mapCarsArray= mapCars;
	
}public void setHousesMap(String[] mapHouses){
	mapHousesArray= mapHouses;
}

public String[] getMapHousesArray(){
	return mapHousesArray;
}
public String[][] getMapCarsArray(){
	return mapCarsArray;
}
}


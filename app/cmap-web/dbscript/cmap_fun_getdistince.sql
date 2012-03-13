-- Function: getdistance(numeric, numeric, numeric, numeric)

-- DROP FUNCTION getdistance(numeric, numeric, numeric, numeric);

CREATE OR REPLACE FUNCTION getdistance(point1_lng numeric, point1_lat numeric, point2_lng numeric, point2_lat numeric)
RETURNS numeric AS
$BODY$
DECLARE EARTHRADIUS NUMERIC; 
		p1Lng NUMERIC;
        p1Lat NUMERIC;
        p2Lng NUMERIC;
        p2Lat NUMERIC;
		x1    NUMERIC;
		y1    NUMERIC;
		x2    NUMERIC;
		y2    NUMERIC;
BEGIN

EARTHRADIUS := 6370996.81;
p1Lng := point1_lng;
p1Lat := point1_lat;
p2Lng := point2_lng;
p2Lat := point2_lat;

LOOP
  IF p1Lng > 180 THEN
    p1Lng := p1Lng - 360;
  ELSE
    EXIT;
  END IF;
END LOOP;

LOOP
  IF p1Lng < -180 THEN
    p1Lng := p1Lng + 360;
  ELSE
    EXIT;
  END IF;
END LOOP;

IF p1Lat < -74 THEN
  p1Lat := -74;
END IF;

IF p1Lat > 74 THEN
  p1Lat := 74;
END IF;

LOOP
  IF p2Lng > 180 THEN
    p2Lng := p2Lng - 360;
  ELSE
    EXIT;
  END IF;
END LOOP;

LOOP
  IF p2Lng < -180 THEN
    p2Lng := p2Lng + 360;
  ELSE
    EXIT;
  END IF;
END LOOP;

IF p2Lat < -74 THEN
  p2Lat := -74;
END IF;

IF p2Lat > 74 THEN
  p2Lat := 74;
END IF;

x1 := PI() * p1Lng/180;
y1 := PI() * p1Lat/180;
x2 := PI() * p2Lng/180;
y2 := PI() * p2Lat/180;

RETURN EARTHRADIUS * ACOS((SIN(y1) * SIN(y2) + COS(y1) * COS(y2) * COS(x2 - x1)));

END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION getdistance(numeric, numeric, numeric, numeric)
  OWNER TO cmap;

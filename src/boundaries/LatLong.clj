(ns boundaries.LatLong)

(defn sin [num] (Math/sin num))
(defn cos [num] (Math/cos num))
(defn to-rads [degs] (* degs (/ Math/PI 180)))
(defn to-degs [rads] (/ (* 180 rads) Math/PI))
(def earth-radius-km 6371) ; in kilometers
(def earth-radius-mi 3968) ; in miles
(def earth-radius earth-radius-mi)

(defn long-dist [lat dist]
  (to-degs
    (/ dist earth-radius
    (cos (to-rads lat)))))

(defn bounding-box [lat lng dist]
	(vector
    (vector
      (+ lat (to-degs (/ dist earth-radius)))  ;maxLat
      (+ lng (long-dist lat dist)))               ;maxLong
    (vector
      (- lat (to-degs (/ dist earth-radius)))  ;minLat
      (- lng (long-dist lat dist)))               ;minLong
    )
  )
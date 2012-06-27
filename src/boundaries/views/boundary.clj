(ns boundaries.views.boundary
  (:use noir.core
    hiccup.core
    hiccup.page-helpers)
  (:require
    [boundaries.LatLong :as LatLong]
    [noir.response :as resp]))

(defpage "/boundary" {:keys [latitude longitude distance]}
  (resp/json ((fn [bounds] {
    :maximum {
      :latitude (first (first bounds)),
      :longitude (second (first bounds))
      },
    :minimum {
      :latitude (first (second bounds)),
      :longitude (second (second bounds))
      }})
  (apply LatLong/bounding-box 
    ((fn [a b c]
      (map read-string [a b c] ))
    latitude longitude distance))))
  )
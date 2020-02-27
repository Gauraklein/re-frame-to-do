(ns simple-re-frame-app.subs
  (:require
   [re-frame.core :as re-frame]))

; subscription for app name
(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))

; subscription for to-dos
(re-frame/reg-sub
  ::to-do
  (fn [db]
    (:to-do db)))

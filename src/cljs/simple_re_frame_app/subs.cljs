(ns simple-re-frame-app.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
  ::to-do
  (fn [db]
    (:to-do db)))

(re-frame/reg-sub
  ::completed
  (fn [db]
    (:completed db)))

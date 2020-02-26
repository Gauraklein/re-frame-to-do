(ns simple-re-frame-app.views
  (:require
   [re-frame.core :as re-frame]
   [simple-re-frame-app.subs :as subs]
   [simple-re-frame-app.events :as events]
   [clojure.string :as str]
   [simple-re-frame-app.util :as util]))

()

(defn render-to-do [to-do]
  [:li {:key to-do}(str (val to-do))
   ; [:button {}
   ;   "edit"]
   [:button {:id (str "complete-" (util/replace-white-space (val to-do)))}
     "complete"]
   [:button {:id (str "delete-" (util/replace-white-space (val to-do)))
             :on-click (fn [e]
                         (.preventDefault e)
                         (re-frame/dispatch [::events/delete-to-do (key to-do)]))}
     "delete"]])


(defn to-do-view []
  (let [to-do (re-frame/subscribe [::subs/to-do])]
    [:div
     [:ul (map render-to-do @to-do)]]))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 @name]
     [:input {:id "new-to-do"}]
     [:button
      {:on-click (fn [e]
                   (.preventDefault e)
                   (re-frame/dispatch [::events/add-to-do (util/get-value "new-to-do")]))}

      "add to-do"]
     (to-do-view)]))

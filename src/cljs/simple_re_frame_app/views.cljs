(ns simple-re-frame-app.views
  (:require
   [re-frame.core :as re-frame]
   [simple-re-frame-app.to_do_list :refer [to-do-list completed-list]]
   [simple-re-frame-app.util :as util]))

;; app structure
(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 @name]
     [:input {:id "new-to-do"}]
     [:button
      {:id "add-to-do"
       :on-click
        (fn [e]
          (.preventDefault e
            (re-frame/dispatch
              [::events/add-to-do
               (util/get-value "new-to-do")])))}
      "add to-do"]
     (to-do-list)
     [:hr]
     [:h1 "Completed"]
     (completed-list)]))

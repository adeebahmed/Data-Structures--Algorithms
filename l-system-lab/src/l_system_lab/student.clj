;; You will need to rewrite this.  This code is just for show.
(ns l_system_lab.student)

(defn remove-empties
  [v]
  (filter #(not= [] %) v))

;;
(defn get-xy-scale
  "Get the scaling factor for the coordinates."
  ([v]  {:scale 1 :min-x 1 :min-y 1})
  ([v min-x min-y max-x max-y]
     {:scale 1 :min-x 1 :min-y 1}))


;; You will need to rewrite this.  This code is just for show.
(defn scale-turtle
  "Normalizes a list of [:line ... ] vectors."
  ([v] (scale-turtle v (get-xy-scale (remove-empties v)) []))
  ([v scale out]
     v ;; For initial, just return the original.
     ))

(defn transform
  [init-pat rules]
  init-pat ;; Make it do something here!
)

;; # Some fractals to start out with.  Add some of your own!

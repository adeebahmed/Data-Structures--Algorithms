;; You will need to rewrite this.  This code is just for show.
(ns l_system_lab.student)

(defn remove-empties
  [v]
  (filter #(not= [] %) v))


(defn get-xy-scale-one
  "Get the scaling factor for the coordinates."
  [v]
  (let [vector1 (v 0)
        [x1 y1 x2 y2] (rest vector1)
        out[]
       xvec (into out [x1 x2])
       yvec (into out [y1 y2])
       xmin (apply min xvec)
       xmax (apply max xvec)
       ymin (apply min yvec)
       ymax (apply max yvec)
       xrange (- xmax xmin)
       yrange (- ymax ymin)]

       (cond (< xrange yrange)
         {:scale (double (/ 480 yrange)), :min-x xmin, :min-y ymin}
         :else  {:scale (double (/ 480 xrange)), :min-x xmin, :min-y ymin})
      )
   )



(defn get-xy-scale-two
  "Get the scaling factor for the coordinates."
  [v]
  (let [vector1 (v 0)
        vector2 (v 1)
        [x1 y1 x2 y2] (rest vector1)
        [x3 y3 x4 y4] (rest vector2)
        out []
       xvec (into out[x1 x2 x3 x4])
       yvec (into out[y1 y2 y3 y4])
       xmin (apply min xvec)
       xmax (apply max xvec)
       ymin (apply min yvec)
       ymax (apply max yvec)
       xrange (- xmax xmin)
       yrange (- ymax ymin)]

       (cond (< xrange yrange)
         {:scale (double (/ 480 yrange)), :min-x xmin, :min-y ymin}
         :else  {:scale (double (/ 480 xrange)), :min-x xmin, :min-y ymin})

    )
  )

(defn get-xy-scale
  [v]
  (cond (= (count v) 1)  (get-xy-scale-one v)
        :else (get-xy-scale-two v)))

(defn scale-turtle-one
  [v]
 (let [vector1 (v 0)
       [x1 y1 x2 y2] (rest vector1)
       out[]
       xvec (into out [x1 x2])
       yvec (into out [y1 y2])
       xmin (apply min xvec)
       ymin (apply min yvec)
       xmax (apply max xvec)
       ymax (apply max yvec)
       xrange (- xmax xmin)
       yrange (- ymax ymin)
       scale (:scale (get-xy-scale v))]

  (into [] [[:line (double (-> x1 (- xmin) (* scale) (+ 10)))
            (double (-> y1 (- ymin) (* scale) (+ 10)))
             (double (-> x2 (- xmin) (* scale) (+ 10)))
             (double (-> y2 (- ymin) (* scale) (+ 10)))
           ]]
   )
 )
)

(defn scale-turtle-two
  [v]
 (let [vector1 (v 0)
       vector2 (v 1)
       [x1 y1 x2 y2] (rest vector1)
       [x3 y3 x4 y4] (rest vector2)
       out[]

       xvec (into out [x1 x2 x3 x4])
       yvec (into out [y1 y2 y3 y4])
       xmin (apply min xvec)
       ymin (apply min yvec)
       xmax (apply max xvec)
       ymax (apply max yvec)
       xrange (- xmax xmin)
       yrange (- ymax ymin)
       scale (:scale (get-xy-scale v))]

  (conj [] [[:line (double (-> x1 (- xmin) (* scale) (+ 10)))
            (double (-> y1 (- ymin) (* scale) (+ 10)))
             (double (-> x2 (- xmin) (* scale) (+ 10)))
             (double (-> y2 (- ymin) (* scale) (+ 10)))]

            [:line (double (-> x3 (- xmin) (* scale) (+ 10)))
             (double (-> y3 (- xmin) (* scale) (+ 10)))
             (double (-> x4 (- xmin) (* scale) (+ 10)))
             (double (-> y4 (- xmin) (* scale) (+ 10)))]]
   )
 )
)


(defn scale-turtle
  [v]
   (if (= (count v) 1)
     (scale-turtle-one v)
   (if (= (count v) 2)
     (scale-turtle-two v)))
)


;; (defn transform
;;   "Creates fractal transformation pattern"
;;   [init-pat rules] ;; passes in a vector (init-pat) and hashmap (rules)
;;   (loop [v init-pat  ;; intitialze vector with the initialzation patten passed in by the user
;;          out[]]
;;     (if (empty? rules) init-pat
;;     (if (empty? v) out ;;outputs empty vector
;;       (if (identical? (first v) (keys rules))  ;; if first ele of vector is equal to the keys within the rules hashmap
;;          (recur (rest v) (into out (rules (first (key rules)))))
;;          (recur (rest v) (into out (rest v)))))))
;; )

(defn transform
  [init-pat rules]
  (cond
   (empty? rules) init-pat
   (empty? init-pat) nil
   (and (= (first init-pat) :f) (not (empty? (:f rules)))) (into (:f rules) (transform (rest init-pat) rules))
   (and (= (first init-pat) :x) (not (empty? (:x rules)))) (into (:x rules) (transform (rest init-pat) rules))
   :else (into [] (cons (first init-pat) (transform (rest init-pat) rules)))
))

;; (defn get-xy-scale
;;   [v]
;;    (if (= (count v) 1)
;;      (get-xy-scale-one v)
;;    (if (= (count v) 2)
;;      (get-xy-scale-two v))) ;else
;; )




;; # Some fractals to start out with.  Add some of your own!

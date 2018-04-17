(set-env! :resource-paths #{"src"})

(require '[boot.git :refer [last-commit]]
         '[adzerk.bootlaces :refer :all])

(def +version+ "0.1.14")

(bootlaces! +version+)

(task-options!
 push {:repo           "deploy"
       :ensure-branch  "master"
       :ensure-clean   true
       :ensure-tag     (last-commit)
       :ensure-version +version+}
 pom  {:project        'entranceplus/bootlaces
       :version        +version+
       :description    "Adzerk's boot configurations for Clojure libraries "
       :url            "https://github.com/entranceplus/bootlaces"
       :scm            {:url "https://github.com/entranceplus/bootlaces"}
       :license        {"Eclipse Public License" "http://www.eclipse.org/legal/epl-v10.html"}})

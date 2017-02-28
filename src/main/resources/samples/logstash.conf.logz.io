input {

        file {
             path => "/root/ansible-provision-docker/NTLDEMO/infrastructure/dockers/docker-elk/logstash/config/logs/devcapsule.log"
             type => "apache-access"
             start_position => "beginning"
        }

##        tcp {
##                port => 5000
##        }


}


## Add your filters / logstash plugins configuration here

filter {

     if "|INFO|" in [message]{
                  grok {
                         named_captures_only => true
                         break_on_match => true
                         match => { "message" => "%{TIMESTAMP_ISO8601:timestamp}\|%{LOGLEVEL:loglevel}\|%{JAVACLASS:class}\|%{DATA:thread}\|TrackingId:%{UUID:TrackingId}\|ClientId:%{UUID:ClientId}\|Transaction:%{DATA:Transaction}\|Price:%{NUMBER:Price}\|OrderNo:%{NUMBER:OrderNo}\|PizzaName:%{DATA:PizzaName}\|BaseName:%{GREEDYDATA:BaseName}" }
                         match => { "message" => "%{TIMESTAMP_ISO8601:timestamp}\|%{LOGLEVEL:loglevel}\|%{JAVACLASS:class}\|%{DATA:thread}\|TrackingId:%{UUID:TrackingId}\|ClientId:%{UUID:ClientId}\|Transaction:%{DATA:Transaction}\|Price:%{NUMBER:Price}\|PizzaName:%{GREEDYDATA:PizzaName}" }
			 match => { "message" => "%{TIMESTAMP_ISO8601:timestamp}\|%{LOGLEVEL:loglevel}\|%{JAVACLASS:class}\|%{DATA:thread}\|TrackingId:%{UUID:TrackingId}\|ClientId:%{UUID:ClientId}\|Transaction:%{DATA:Transaction}\|BaseName:%{GREEDYDATA:BaseName}" }
                         match => { "message" => "%{TIMESTAMP_ISO8601:timestamp}\|%{LOGLEVEL:loglevel}\|%{JAVACLASS:class}\|%{DATA:thread}\|TrackingId:%{UUID:TrackingId}\|ClientId:%{UUID:ClientId}\|Transaction:%{DATA:Transaction}\|ToppingName:%{GREEDYDATA:ToppingName}" }
                         match => { "message" => "%{TIMESTAMP_ISO8601:timestamp}\|%{LOGLEVEL:loglevel}\|%{JAVACLASS:class}\|%{DATA:thread}\|%{GREEDYDATA:LogMessage}" }

                  }
     }


     mutate {
           add_field => { "token" => "FDSnpqmIWzTphYDoScPLoCTYmBXvfIGI" }
     }

}




output {
       ##    elasticsearch {
       ##       hosts => "elasticsearch:9200"
       ##    }

       tcp {
               host => "listener.logz.io"
               port => 5050
               codec => json_lines
            }



}






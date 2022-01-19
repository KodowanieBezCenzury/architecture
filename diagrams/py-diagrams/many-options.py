# quick-start-diagram.py
from diagrams import Cluster, Diagram
from diagrams.onprem.network import Nginx
from diagrams.onprem.analytics import Spark
from diagrams.onprem.database import Neo4J
from diagrams.onprem.database import Cassandra
from diagrams.onprem.database import Mongodb
from diagrams.onprem.monitoring import Splunk
from diagrams.onprem.client import User
from diagrams.programming.framework import Spring
from diagrams.programming.framework import Vue
from diagrams.programming.framework import React
from diagrams.programming.framework import Angular
from diagrams.programming.language import Rust

with Diagram("How many tech I can fit into one app", show=False):
    
    client = User("Our client")
    splunk = Splunk("Splunk")
    spark = Spark("Spark")

    with Cluster("My App"):
        lb = Nginx("lb")
        service_a = Spring("Service A")
        service_b = Spring("Service B")
        service_c = Spring("Service C")
        native = Rust("app")
        mongo_db = Mongodb("Mongodb")
        cassandra = Cassandra("Cassandra")
        neo4j = Neo4J("Neo4J")

        with Cluster("UI"):
            vue = Vue("Micro Front1")
            react = React("Micro Front2")
            angular = Angular("Micro Front3")

        client >> lb
        lb >> vue >> service_a >> mongo_db >> spark
        lb >> react >> service_b >> cassandra >> spark
        lb >> angular >> service_c >> neo4j >> spark
        service_a >> native
        service_a >> splunk
        service_b >> splunk
        service_c >> splunk

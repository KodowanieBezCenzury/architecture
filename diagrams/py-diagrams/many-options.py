# quick-start-diagram.py
from diagrams import Diagram
from diagrams.aws.compute import EC2
from diagrams.aws.database import RDS
from diagrams.aws.network import ELB
from diagrams.aws.analytics import Athena
from diagrams.onprem.analytics import Spark
from diagrams.onprem.database import Neo4J
from diagrams.onprem.monitoring import Splunk
from diagrams.programming.framework import Spring
from diagrams.programming.framework import Vue
from diagrams.programming.language import Rust
with Diagram("Many Options", show=False):
    lb = ELB("lb")
    web = EC2("web")
    service = Spring("Service")
    native = Rust("app")
    spark = Spark("Spark")
    lb >> Vue("UI") >> web >> RDS("userdb")
    web >> Athena("athena")
    web >> Neo4J("Neo4J")
    web >> service >> spark 
    service >> native
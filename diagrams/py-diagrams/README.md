# Python Diagrams 🎞[youtube video link](https://www.youtube.com/watch?v=8zxn22dXga0)🎞
* Official site: [https://diagrams.mingrammer.com/](https://diagrams.mingrammer.com/)
* Quick start: [https://diagrams.mingrammer.com/docs/getting-started/installation#quick-start](https://diagrams.mingrammer.com/docs/getting-started/installation#quick-start)
* Examples: [https://diagrams.mingrammer.com/docs/getting-started/examples](https://diagrams.mingrammer.com/docs/getting-started/examples)
## [Installation](https://diagrams.mingrammer.com/docs/getting-started/installation)
<details>
<summary>Linux</summary>

```bash
#> Linux
sudo apt-get install -y graphviz
```

</details>

<details>
<summary>Mac</summary>

```bash
#> Mac
brew install graphviz
```

</details>

<details>
<summary>Windows</summary>

```bash
#> Windows
choco install python3
choco install graphviz
```

</details>

<details>
<summary>Diagrams itself</summary>

```bash
# Tool
#> using pip (pip3)
#pip install diagrams
#> using poetry
#poetry add diagrams
#> using pipenv
pipenv install diagrams
pipenv shell
```
</details>

## Diagrams Installation
```bash
pipenv install diagrams
pipenv shell
python3 py-diagrams/quick-start-diagram.py
python3 py-diagrams/k8s-diagram.py
python3 py-diagrams/aws-cluster.py
python3 py-diagrams/many-options.py
```
## Integration with Jupyterlab
```bash
pipenv install jupyterlab
pipenv shell
pip install diagrams
jupyter lab
```

## Example diagrams
* [Quick Start](quick-start-diagram.py)
* [K8S Diagram](k8s-diagram.py)
* [AWS Cluster](aws-cluster.py)
* [Showcase](many-options.py)

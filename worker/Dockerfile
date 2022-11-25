FROM docker.io/bde2020/spark-base:3.0.0-hadoop3.2

LABEL maintainer="Gezim Sejdiu <g.sejdiu@gmail.com>, Giannis Mouchakis <gmouchakis@gmail.com>"

COPY worker.sh /

ENV SPARK_WORKER_WEBUI_PORT 8081
ENV SPARK_WORKER_LOG /spark/logs
ENV SPARK_MASTER "spark://spark-master:7077"

EXPOSE 8081

# install python 3 and jupyter notebook

ENV PYTHONUNBUFFERED=1
RUN apk add --update --no-cache gcc python3-dev python3 linux-headers musl-dev libffi-dev && \
    ln -sf python3.8.5 /usr/bin/python && \
	python3 -m ensurepip && \
	pip3 install --no-cache --upgrade pip setuptools && \
	pip3 install --no-cache notebook kafka-python

# setup python3
ENV PYSPARK_PYTHON=python3 
ENV PYSPARK_DRIVER_PYTHON=jupyter 
ENV PYSPARK_DRIVER_PYTHON_OPTS="notebook --ip=0.0.0.0 --port=8888 --no-browser --allow-root --NotebookApp.token='' --NotebookApp.password=''" 

CMD ["/bin/bash", "/worker.sh"]

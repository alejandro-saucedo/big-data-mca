package com.packt.mapreduce.minmax;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;
public class MinMaxReducer extends Reducer<Text, PlayerDetail, Text,
        PlayerReport> {
    PlayerReport playerReport = new PlayerReport();
    @Override
    protected void reduce(Text key, Iterable<PlayerDetail> values, Context
            context) throws IOException, InterruptedException {
        playerReport.setPlayerName(key);
        playerReport.setMaxScore(new IntWritable(0));
        playerReport.setMinScore(new IntWritable(Integer.MAX_VALUE));
	playerReport.setMaxScoreOpposition(new IntWritable(0));
        playerReport.setMinScoreOpposition(new IntWritable(0));
        for (PlayerDetail playerDetail : values) {
            int score = playerDetail.getScore().get();
	    int opp = playerDetail.getOpposition().get();
            if (score > playerReport.getMaxScore().get()) {
                playerReport.getMaxScore().set(score);
                playerReport.getMaxScoreOpposition().set(opp);
            }
            if (score < playerReport.getMinScore().get()) {
                playerReport.getMinScore().set(score);
                playerReport.getMinScoreOpposition().set(opp);
            }
        }
	context.write(key, playerReport);
    }
}

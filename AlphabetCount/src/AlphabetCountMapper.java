import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AlphabetCountMapper extends
		Mapper<LongWritable, Text, IntWritable, IntWritable> {

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String[] words = value.toString().split(" ");
		for (String s : words) {
			context.write(new IntWritable(s.length()), new IntWritable(1));
		}
	}
}

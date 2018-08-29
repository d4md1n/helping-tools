import java.util.LinkedList;
import java.util.List;
import java.util.stream.LongStream;

import ctp.functests.coretests.prizespecs.ClaimMultiplePrizesForTheSamePlayerSpec;
import spock.util.EmbeddedSpecRunner;

class RunASpockTestMultipleTimes {
    public static void main(String[] args) {
        EmbeddedSpecRunner runner = new EmbeddedSpecRunner();
        List res = new LinkedList();
        long total = 25;
        LongStream range = LongStream.rangeClosed(1, total);
        range.forEach(v -> {
            try {
                System.out.println("run number: " + v);
                res.add(runner.runClass(ClaimMultiplePrizesForTheSamePlayerSpec.class).wasSuccessful());
                Thread.sleep(1000);
            } catch (Exception e) {
                res.add(false);
            }
        });

        long succeeded = res.stream().filter(v -> v.equals(true)).count();
        long failed = res.stream().filter(v -> v.equals(false)).count();
        System.out.println("succeeded tests " + succeeded + " % " + (double) (succeeded/total) * 100);
        System.out.println("failed tests " + failed + " % " + (double) (failed/total) * 100);
    }
}

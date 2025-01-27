library(tidyverse)

simulation_visual <- read_csv("data/test.csv")
simulation_visual <- simulation_visual |>
  pivot_longer(cols = !time, names_to = "simNum", values_to = "price")

# Determine the number of unique simulations
num_sims <- length(unique(simulation_visual$simNum))

# Generate a color palette using colorRampPalette, repeating the shades of blue
colors <- colorRampPalette(c("#9ac0cc", "#056a62"))(num_sims)

sim_plot <- simulation_visual |>
  ggplot(aes(x = time, y = price, color = simNum)) +
  geom_line(alpha = 0.5, size = 0.3) +
  scale_color_manual(values = colors) +
  xlab("Time") +
  ylab("Price(USD)") +
  theme(legend.position = "none") +
  ggtitle("Monte Carlo Simulation of GOOGL 200 Sims 500 Steps", size = 12)

ggsave(filename = "scripts/visuals/GOOGL.png",
       plot = sim_plot, width = 6, height = 4)
